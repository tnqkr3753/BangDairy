(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Main");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("user_info", this);
            obj._setContents("<ColumnInfo><Column id=\"user_id\" type=\"STRING\" size=\"20\"/><Column id=\"user_password\" type=\"STRING\" size=\"20\"/><Column id=\"user_gender\" type=\"STRING\" size=\"10\"/><Column id=\"user_birth\" type=\"DATE\" size=\"10\"/><Column id=\"user_email\" type=\"STRING\" size=\"30\"/></ColumnInfo><Rows><Row><Col id=\"user_id\">bori5</Col><Col id=\"user_password\">bori5</Col><Col id=\"user_gender\">F</Col><Col id=\"user_birth\">19960905</Col><Col id=\"user_email\">bej96@naver.com</Col></Row><Row><Col id=\"user_id\">aaa123</Col><Col id=\"user_password\">aaa123</Col><Col id=\"user_gender\">M</Col><Col id=\"user_birth\">19961205</Col><Col id=\"user_email\">aaa123@naver.com</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("user_qna", this);
            obj._setContents("<ColumnInfo><Column id=\"qna_id\" type=\"STRING\" size=\"10\"/><Column id=\"user_id\" type=\"STRING\" size=\"20\"/><Column id=\"qna_title\" type=\"STRING\" size=\"50\"/><Column id=\"qna_content\" type=\"STRING\" size=\"256\"/><Column id=\"qna_reg_date\" type=\"DATE\" size=\"20\"/><Column id=\"qna_status\" type=\"STRING\" size=\"20\"/><Column id=\"qna_answer\" type=\"STRING\" size=\"1000\"/></ColumnInfo><Rows><Row><Col id=\"qna_id\">1</Col><Col id=\"user_id\">bori5</Col><Col id=\"qna_title\">넥사크로</Col><Col id=\"qna_content\">어려움</Col><Col id=\"qna_reg_date\">20200804</Col><Col id=\"qna_status\">답변대기</Col></Row><Row><Col id=\"qna_id\">2</Col><Col id=\"user_id\">aaa5</Col><Col id=\"qna_title\">nexa</Col><Col id=\"qna_content\">cro</Col><Col id=\"qna_reg_date\">20200101</Col><Col id=\"qna_status\">답변대기</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Tab("TabPage","2.27%","4.17%","95.39%","91.67%",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_tabindex("0");
            obj.set_selectchangetype("down");
            obj.set_tabposition("left");
            obj.set_tabbuttonheight("60");
            obj.set_tabbuttonwidth("130");
            obj.set_border("1px solid black");
            obj.set_font("20px/normal \"Tmon몬소리 Black\"");
            this.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage1",this.TabPage);
            obj.set_text("사용자 관리");
            this.TabPage.addChild(obj.name, obj);

            obj = new Div("Div00","21","22","1043","86",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("0");
            obj.set_text("Div00");
            obj.set_border("1px solid #9c9c9c");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Static("Static00","23","13","223","57",null,null,null,null,null,null,this.TabPage.Tabpage1.form.Div00.form);
            obj.set_taborder("0");
            obj.set_text("사용자 조회");
            obj.set_font("24px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.form.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit00","158","15","231","53",null,null,null,null,null,null,this.TabPage.Tabpage1.form.Div00.form);
            obj.set_taborder("1");
            this.TabPage.Tabpage1.form.Div00.addChild(obj.name, obj);

            obj = new Button("Button00","400","15","131","53",null,null,null,null,null,null,this.TabPage.Tabpage1.form.Div00.form);
            obj.set_taborder("2");
            obj.set_text("검색");
            obj.set_font("bold 20px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.form.Div00.addChild(obj.name, obj);

            obj = new Grid("Grid00","22","119","543","519",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("1");
            obj.set_font("16px/normal \"Tmon몬소리OTF Black\"");
            obj.set_binddataset("user_info");
            obj.set_border("1px solid #9c9c9c");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"122\"/><Column size=\"164\"/><Column size=\"255\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"아이디\"/><Cell col=\"1\" text=\"생년월일\"/><Cell col=\"2\" text=\"이메일\"/></Band><Band id=\"body\"><Cell text=\"bind:user_id\"/><Cell col=\"1\" text=\"bind:user_birth\"/><Cell col=\"2\" text=\"bind:user_email\"/></Band></Format></Formats>");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Static("Static00_00","630","138","139","106",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("2");
            obj.set_text("아이디");
            obj.set_font("26px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Static("Static00_00_00","630","205","139","106",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("3");
            obj.set_text("비밀번호");
            obj.set_font("26px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Static("Static00_00_01","630","272","139","106",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("4");
            obj.set_text("성별");
            obj.set_font("26px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Static("Static00_00_02","630","338","139","106",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("5");
            obj.set_text("생년월일");
            obj.set_font("26px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Static("Static00_00_03","630","406","139","106",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("6");
            obj.set_text("이메일");
            obj.set_font("26px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Edit("Edit00_00","775","174","230","35",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("7");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Edit("Edit00_00_00","775","241","230","35",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("8");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Calendar("Calendar00","775","371","230","35",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("9");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Radio("Radio00","775","303","280","50",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("10");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_font("bold 24px/normal \"Tmon몬소리OTF Black\"");
            obj.set_direction("vertical");
            var TabPage_Tabpage1_form_Radio00_innerdataset = new nexacro.NormalDataset("TabPage_Tabpage1_form_Radio00_innerdataset", obj);
            TabPage_Tabpage1_form_Radio00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">M</Col><Col id=\"datacolumn\">Male</Col></Row><Row><Col id=\"codecolumn\">F</Col><Col id=\"datacolumn\">Female</Col></Row></Rows>");
            obj.set_innerdataset(TabPage_Tabpage1_form_Radio00_innerdataset);
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Edit("Edit00_00_00_00","775","441","230","35",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("11");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Button("Button00","880","558","125","70",null,null,null,null,null,null,this.TabPage.Tabpage1.form);
            obj.set_taborder("12");
            obj.set_text("탈퇴");
            obj.set_font("bold 20px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage1.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage2",this.TabPage);
            obj.set_text("문의 관리");
            this.TabPage.addChild(obj.name, obj);

            obj = new Grid("Grid00","20","24","1040","320",null,null,null,null,null,null,this.TabPage.Tabpage2.form);
            obj.set_taborder("0");
            obj.set_binddataset("user_qna");
            obj.set_font("14pt/normal \"Tmon몬소리OTF Black\"");
            obj.set_border("1px solid #9c9c9c");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"94\"/><Column size=\"183\"/><Column size=\"350\"/><Column size=\"300\"/><Column size=\"110\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"번호\"/><Cell col=\"1\" text=\"사용자\"/><Cell col=\"2\" text=\"제목\"/><Cell col=\"3\" text=\"등록일\"/><Cell col=\"4\" text=\"답변 상태\"/></Band><Band id=\"body\"><Cell text=\"bind:qna_id\"/><Cell col=\"1\" text=\"bind:user_id\"/><Cell col=\"2\" text=\"bind:qna_title\"/><Cell col=\"3\" text=\"bind:qna_reg_date\"/><Cell col=\"4\" text=\"bind:qna_status\"/></Band></Format></Formats>");
            this.TabPage.Tabpage2.addChild(obj.name, obj);

            obj = new TextArea("TextArea00","21","403","436","242",null,null,null,null,null,null,this.TabPage.Tabpage2.form);
            obj.set_taborder("1");
            this.TabPage.Tabpage2.addChild(obj.name, obj);

            obj = new Static("Static00","21","350","208","50",null,null,null,null,null,null,this.TabPage.Tabpage2.form);
            obj.set_taborder("2");
            obj.set_text("문의내용");
            obj.set_font("bold 24px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage2.addChild(obj.name, obj);

            obj = new Static("Static00_00","481","353","208","50",null,null,null,null,null,null,this.TabPage.Tabpage2.form);
            obj.set_taborder("3");
            obj.set_text("답변내용");
            obj.set_font("bold 24px/normal \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage2.addChild(obj.name, obj);

            obj = new TextArea("TextArea00_00","481","403","436","242",null,null,null,null,null,null,this.TabPage.Tabpage2.form);
            obj.set_taborder("4");
            this.TabPage.Tabpage2.addChild(obj.name, obj);

            obj = new Button("btn_qna_register","931","571","127","71",null,null,null,null,null,null,this.TabPage.Tabpage2.form);
            obj.set_taborder("5");
            obj.set_text("등록");
            obj.set_font("bold 20pt \"Tmon몬소리OTF Black\"");
            this.TabPage.Tabpage2.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage3",this.TabPage);
            obj.set_text("컨텐츠 관리");
            this.TabPage.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage4",this.TabPage);
            obj.set_text("통계");
            this.TabPage.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item3","TabPage.Tabpage1.form.Radio00","value","user_info","user_gender");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item4","TabPage.Tabpage1.form.Calendar00","value","user_info","user_birth");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item6","TabPage.Tabpage2.form.TextArea00","value","user_qna","qna_content");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item7","TabPage.Tabpage2.form.TextArea00_00","value","user_qna","qna_answer");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item0","TabPage.Tabpage1.form.Edit00_00","value","user_info","user_id");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","TabPage.Tabpage1.form.Edit00_00_00","value","user_info","user_password");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","TabPage.Tabpage1.form.Edit00_00_00_00","value","user_info","user_email");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Main.xfdl", function() {

        this.Tab00_onchanged = function(obj,e)
        {
        	alert("변경");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.TabPage.addEventHandler("onchanged",this.Tab00_onchanged,this);
            this.TabPage.Tabpage1.form.Div00.form.Static00.addEventHandler("onclick",this.TabPage_Tabpage1_Div00_Static00_onclick,this);
            this.TabPage.Tabpage1.form.Edit00_00.addEventHandler("onchanged",this.TabPage_Tabpage1_Edit00_00_onchanged,this);
            this.TabPage.Tabpage1.form.Edit00_00_00.addEventHandler("onchanged",this.TabPage_Tabpage1_Edit00_00_00_onchanged,this);
            this.TabPage.Tabpage1.form.Edit00_00_00_00.addEventHandler("onchanged",this.TabPage_Tabpage1_Edit00_00_00_onchanged,this);
        };

        this.loadIncludeScript("Main.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
