(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Work");
            this.set_titletext("Form_Work");
            if (Form == this.constructor)
            {
                this._setFormPosition(1050,540);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("rename", this);
            obj._setContents("<ColumnInfo><Column id=\"user_id\" type=\"STRING\" size=\"256\"/><Column id=\"user_email\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","60","113","500","394",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("rename");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"100\"/><Column size=\"80\"/><Column size=\"48\"/></Columns><Rows><Row size=\"40\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"user_id\"/><Cell col=\"1\" text=\"user_email\"/><Cell col=\"2\"/></Band><Band id=\"body\"><Cell text=\"bind:user_id\"/><Cell col=\"1\" text=\"bind:user_email\"/><Cell col=\"2\" displaytype=\"buttoncontrol\" text=\"밴\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","260","67","83","40",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("검색");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","60","70","197","35",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","64","16","245","64",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("유저 밴 목록");
            obj.set_font("normal 20pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1050,540,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Work.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
         	var search_keyword =  encodeURI(this.Edit00.value,"UTF-8");
         	 var id = "adminUserBanList";
              //var url = "strURL::adminUserBanList.jsp";
         	  var url ="http://115.91.88.227:60003/bangdairy/adminUserBanList?param="+search_keyword;
              var reqDs = "";
              var respDs = "rename=rename";
              var args = "";
              var callback = "received";
              this.transaction(id, url, reqDs, respDs, args, callback);
           this.received = function(id, code, message)
         {
         }
        };

        this.Form_Work_onload = function(obj,e)
        {

         	 var id = "adminUserBanList";
              //var url = "strURL::adminUserBanList.jsp";
         	  var url ="http://115.91.88.227:60003/bangdairy/adminUserBanList";
              var reqDs = "";
              var respDs = "rename=rename";
              var args = "";
              var callback = "received";
              this.transaction(id, url, reqDs, respDs, args, callback);
           this.received = function(id, code, message)
         {
        	alert(code);
         }
        };


        this.Grid_cell_onclick = function(obj,e)
        {
        	//선택된 행의 인덱스 번호
        	var idx = this.Grid00.selectstartrow;
        	var userId = this.Grid00.getCellText(idx,0);
        	if (e.col == 2){
        		var rtn = this.confirm("사용자 밴을 해제 하시겠습니까?","System");
        		if (rtn){
        			var id = "adminAllowUser";
        			var url ="http://115.91.88.227:60003/bangdairy/adminAllowUser?userId="+userId;
        			var reqDs = "";
        			var respDs = "rename=rename";
        			var args = "";
        			var callback = "received";
        			this.transaction(id, url, reqDs, respDs, args, callback);
        			this.received = function(id, code, message)
        			{
        				this.Form_Work_onload();
        			}
        		}
        	}


        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_Work_onload,this);
            this.Grid00.addEventHandler("oncellclick",this.Grid_cell_onclick,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Edit00.addEventHandler("onchanged",this.Edit00_onchanged,this);
            this.Static00.addEventHandler("onclick",this.Static00_onclick,this);
        };

        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
