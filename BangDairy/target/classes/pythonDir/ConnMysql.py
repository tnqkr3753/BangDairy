# -*- coding: utf-8 -*-

import pymysql
import csv
import numpy as np
import pandas as pd
import sklearn
from sklearn import decomposition


def connsql(data):
    list2 = []
    host = "192.168.0.110"
    user = 'movie'
    passwd = '1234'
    db = 'moviedb'
    # sql 연결
    conn = pymysql.connect(host, user, passwd, db)
    # 커넥션으로 부터 커서 생성
    cursor = conn.cursor()
    # sql문 생성
    sql = [" select movie_id,movie_title from movie_info",'select movie_id,user_id,score from movie_score']
    # sql문 실행
    if data==1:
        cursor.execute(sql[0])
    else:
        cursor.execute(sql[1])
    # 데이터 패치
    for i in cursor:
        list2.append(i)
    # 커넥션 닫기
    cursor.close()
    conn.close()
    return list2
