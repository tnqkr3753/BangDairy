(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("testpage");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("rename", this);
            obj._setContents("<ColumnInfo><Column id=\"user_id\" type=\"STRING\" size=\"256\"/><Column id=\"date\" type=\"DATE\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset01", this);
            obj._setContents("<ColumnInfo><Column id=\"user_id\" type=\"STRING\" size=\"256\"/><Column id=\"date\" type=\"DATE\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("Button00","177","30","153","55",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("검색");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","16","35","159","51",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","18","96","691","471",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_binddataset("Dataset00");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row band=\"head\" size=\"24\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"user_id\"/><Cell col=\"1\" text=\"date\"/></Band><Band id=\"body\"><Cell text=\"bind:user_id\"/><Cell col=\"1\" text=\"bind:date\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("testpage.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
        	var search_keyword =  encodeURI(this.Edit00.value,"UTF-8");
        	this.alert(search_keyword)
        	 var id = "urlTest02";
             //var url = "strURL::deptAdd;
        	 var url ="http://192.168.0.22:8080/bangdairy/admin";
             var reqDs = "";
             var respDs = "";
             var args = "";
             var callback = "received";
             this.transaction(id, url, reqDs, respDs, args, callback);
          this.received = function(id, code, message)
        {
             alert(code);
        }
        };

        this.Edit00_onchanged = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Edit00.addEventHandler("onchanged",this.Edit00_onchanged,this);
        };

        this.loadIncludeScript("testpage.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
