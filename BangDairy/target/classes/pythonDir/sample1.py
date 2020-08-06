# -*- coding: utf-8 -*-

import pymysql
import csv
import numpy as np
import pandas as pd
import sklearn
from sklearn import decomposition
import ConnMysql
import math

# 영화 정보와 유저 정보 불러 오기
movie_list = ConnMysql.connsql(1)
user_list = ConnMysql.connsql(2)

# 유저 정보와 영화 정보를 pandas 데이터프레임으로 변환
movie_list = pd.DataFrame(movie_list,columns=['movie_id','movie_title'])
user_list = pd.DataFrame(user_list,columns=['movie_id','user_id','rating'])

# 두 데이터를 merge
user_movie_rating = pd.merge(user_list,movie_list, on='movie_id')


# 인덱스를 영화 컬럼을 유저로 변경 평점을 매기지 않은 영화는 0으로 처리
movie_user_rating = user_movie_rating.pivot_table('rating',index='movie_title',columns='user_id').fillna(0)

#아이템 기반 협업 필터링
item_based_collabor = sklearn.metrics.pairwise.cosine_similarity(movie_user_rating)

# 인덱스=영화제목 컬럼=영화제목
item_based_collabor = pd.DataFrame(data=item_based_collabor,index=movie_user_rating.index,columns=movie_user_rating.index)

# 영화 컬럼 검색
def get_item_based_collabor(title):
    return item_based_collabor[title].sort_values(ascending=False)[:5]


print(get_item_based_collabor('해리 포터와 불사조 기사단'))