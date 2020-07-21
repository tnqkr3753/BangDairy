/*
 Textile Toolbar jQuery plugin

 Based on Redmine reStructuredText Formatter
 developed by William Melody
 https://github.com/alphabetum/redmine_restructuredtext_formatter

 Adapted as generic jQuery plugin by Maurizio Manetti

 */

;(function( $, window, document, undefined ) {

  "use strict";

  var pluginName = "textileToolbar";

  // available buttons
  var buttons = {
    spacer: {
        type: "spacer"
      },
    strong: {
        type: "singleTag",
        title: "Strong",
        class: "strong",
        tag: "*"
      },
    italic: {
        type: "singleTag",
        title: "Italic",
        class: "em",
        tag: "_"
      },
    underline: {
        type: "singleTag",
        title: "Underline",
        class: "ins",
        tag: "+"
      },
    deleted: {
        type: "singleTag",
        title: "Deleted",
        class: "del",
        tag: "-"
      },
    code: {
        type: "singleTag",
        title: "Code",
        class: "code",
        tag: "@"
      },
    h1: {
        type: "encloseLine",
        title: "Heading 1",
        class: "h1",
        startTag: "h1. ",
        endTag: "",
        searchExpression: /^h\d+\.\s+/,
        replacement: ""
      },
    h2: {
        type: "encloseLine",
        title: "Heading 2",
        class: "h2",
        startTag: "h2. ",
        endTag: "",
        searchExpression: /^h\d+\.\s+/,
        replacement: ""
      },  
    h3: {
        type: "encloseLine",
        title: "Heading 3",
        class: "h3",
        startTag: "h3. ",
        endTag: "",
        searchExpression: /^h\d+\.\s+/,
        replacement: ""
      },
    ul: {
        type: "encloseLine",
        title: "Unordered list",
        class: "ul",
        startTag: "",
        endTag: "",
        searchExpression: /(\n|^)[*-]?\s*/g,
        replacement: "$1* "
      },
    ol: {
        type: "encloseLine",
        title: "Ordered list",
        class: "ol",
        startTag: "",
        endTag: "",
        searchExpression: /(\n|^)[*-]?\s*/g,
        replacement: "$1# "
      },
    pre:  {
        type: "encloseLine",
        title: "Preformatted text",
        class: "pre",
        startTag: "<pre>\n",
        endTag: "\n</pre>",
        searchExpression: false,
        replacement: ""
      },
    img: {
        type: "singleTag",
        title: "Image",
        class: "img",
        tag: "!"
      },
    link: {
        type: "insertLink",
        title: "Link",
        class: "link"
      },
    url: {
        type: "link",
        title: "Help",
        class: "help",
        url: "about:blank",
        window_properties: "resizable=yes, location=no, width=300, height=640, menubar=no, status=no, scrollbars=yes"
       }
  }

  // default toolbar options
  var defaults = {
    buttons: buttons,
    toolbar: [
      "strong",
      "italic",
      "underline",
      "deleted",
      "code",
      "spacer",
      "h1",
      "h2",
      "h3",
      "spacer",
      "ul",
      "ol",
      "spacer",
      "pre",
      "spacer",
      "img",
      "link"
    ],
    placement: 'beforeElement'
    /*
     Possible placement values:
      string 'beforeElement' default: place toolbar div immediately before the textarea
      string 'afterElement' place toolbar div immediately after the textarea
      string 'beforeParent' place toolbar div before the textarea's parent container
      string 'afterParent' place toolbar div after the textarea's parent container
      function callback returning jQuery element before which to place the toolbar
    */

  };

  function TextileToolbar( element, options ) {
    options = options || {};
    this.textarea = element;
    this.settings = {};
    this.settings.toolbar = options.toolbar || defaults.toolbar;
    this.settings.buttons = $.extend( {}, defaults.buttons, options.buttons);
    this.settings.placement = options.placement || defaults.placement;
    this._defaults = defaults;
    this._name = pluginName;
    this.init();
  }

  TextileToolbar.defaultToolbar = defaults.toolbar;

  TextileToolbar.prototype.getSelection = function(line) {
    var textarea = this.textarea;
    line = line || "";
    var i, o ,s, l;

    if ("undefined" !== typeof document.selection) {
      s = document.selection.createRange().text;
    } else if ("undefined" !== typeof textarea.setSelectionRange) {
      o = textarea.selectionStart;
      i = textarea.selectionEnd;
      l = textarea.scrollTop;
      if (line) {
        o = textarea.value.substring(0, o).replace(/[^\r\n]*$/g, "").length;
        i = textarea.value.length - textarea.value.substring(i, textarea.value.length).replace(/^[^\r\n]*/, "").length;
      }
      s = textarea.value.substring(o, i);
    }

    return {o: o, i:i, s: s, l: l};
  };

  TextileToolbar.prototype.myEncloseSelection = function(e, t, n, line) {
    var textarea = this.textarea;
    textarea.focus();
    e = e || "";
    t = t || "";

    var selection, a, r;
    selection = this.getSelection(line);

    if (selection.s.match(/ $/)) {
      selection.s = selection.s.substring(0, selection.s.length - 1);
      t += " ";
    }

    if ("function" === typeof n) {
      r = selection.s ? n.call(this, selection.s) : n("");
    } else {
      r = selection.s ? selection.s : "";
    }

    a = e + r + t;

    if ("undefined" !== typeof document.selection) {
      document.selection.createRange().text = a;
      var c = textarea.createTextRange();
      c.collapse(!1);
      c.move("character", -t.length);
      c.select();
    } else if ("undefined" !== typeof textarea.setSelectionRange) {
      textarea.value = textarea.value.substring(0, selection.o) + a + textarea.value.substring(selection.i);
      if (selection.s) {
        textarea.setSelectionRange(selection.o + a.length, selection.o + a.length);
      } else {
        textarea.setSelectionRange(selection.o + e.length, selection.o + e.length);
      }
      textarea.scrollTop = selection.l;
    }
  };

  TextileToolbar.prototype.encloseLineSelection = function(e, t, n) {
    this.myEncloseSelection(e, t, n, true);
  };

  TextileToolbar.prototype.encloseSelection = function(e, t, n) {
    this.myEncloseSelection(e, t, n, false);
  };

  TextileToolbar.prototype.singleTag = function(e, t) {
    e = e || null;
    t = t || e;
    if (e && t) {
      this.encloseSelection(e, t);
    }
  };

  TextileToolbar.prototype.init = function () {
    var settings = this.settings;
    var textarea = this.textarea;
    var placement = this.settings.placement;
    var toolbar = this;

    var toolbarDiv = $("<div class=\"textile-toolbar\"></div>");
    var htmlButton;

    var defaultPlacement = function() {$(toolbarDiv).insertBefore(textarea);};

    // create buttons based on the configuration
    $.each(settings.toolbar, function(index, buttonName) {
      var button = settings.buttons[buttonName];
      if (!button) return;
      if (button.type === "spacer") {
        htmlButton = $("<span class=\"tt-spacer\"></span>");
      } else {
        htmlButton = $("<button type=\"button\" class=\"tt-" + button.class + "\" title=\"" + button.title + "\"></button>");
        switch (button.type) {
          case "singleTag":
            htmlButton.on("click", function() { toolbar.singleTag(button.tag); });
          break;
          case "enclose":
            htmlButton.on("click", function() { toolbar.encloseSelection(button.startTag, button.endTag); });
          break;
          case "encloseLine":
            htmlButton.on("click", function() {
              if (button.searchExpression) {
                toolbar.encloseLineSelection(button.startTag, button.endTag, function(e) {
                    e = e.replace(/\r/g, "");
                    e = e.replace(button.searchExpression, button.replacement);
                    return e;
                });
              } else {
                toolbar.encloseLineSelection(button.startTag, button.endTag);
              }
            });
          break;
          case "insertLink":
            htmlButton.on("click", function() {
              var url = prompt("Please provide URL address: ", "");
              if (url) {
                toolbar.encloseSelection("\"", "\":"+url);
              }
            });
          break;
          case "link":
            htmlButton.on("click", function() {
              if (button.callback) {
                button.callback();
              } else if (button.url) {
                window.open(button.url, "", button.window_properties);
              }
            });
          break;
        }
      }
      toolbarDiv.append(htmlButton);
    });

    // insert toolbar based on settings placement:
    if (typeof placement === "string") {
     switch (placement) {
      case "beforeElement": 
        $(toolbarDiv).insertBefore(textarea);
      break;  
      case "afterElement":
        $(toolbarDiv).insertAfter(textarea);
      break;  
      case "beforeParent":
        $(toolbarDiv).insertBefore($(textarea).parent());
      break;  
      case "afterPrent":
        $(toolbarDiv).insertAfter($(textarea).parent());
      break;  
      default:
        console.warn("Unexpected placement indication: \"%s\". Using default.", placement);
        defaultPlacement();
     }
    } else if (typeof placement === "function") {
      var element = placement();
      if (typeof element === "undefined" || element.length === 0) {
        console.warn("Placement function did not return any matching element: using default");
        defaultPlacement();
      } else {
        $(toolbarDiv).insertBefore(element);
      }
    } else {
      defaultPlacement();
    }
    
  };

  TextileToolbar.prototype._reset = function(){
    // remove added dom elements and event bindings
    // method should never be called alone
    var textarea = this.textarea;
    // reset interface and event binding
    $(textarea).prev(".textile-toolbar").remove();
  };

  TextileToolbar.prototype.destroy = function(){
    var textarea = this.textarea;
    this._reset();
    // remove data attributes (we are deleting the instance completely)
    $(textarea).removeData("plugin_" + this._name);
  };

  TextileToolbar.prototype.repaint = function(){
    // reset and re-apply
    this._reset();
    this.init();
  };

  // evaluate method call or creation (similar to jQuery UI widget factory)
  // prevent against multiple instantiations
  // attach the plugin in the data-attribute of matched elements
  $.fn[pluginName] = function ( options ) {
    var isMethodCall = typeof options === "string";
    if ( isMethodCall ) {
      return this.each( function() {
        var instance = $.data(this, "plugin_" + pluginName);
        if (!instance) {
          // error: instance not initialized
          console.error("Cannot call methods on " + pluginName + " prior to initialization; attempted to call method '" + options + "'" );
        } else if ( !$.isFunction(instance[options]) ) {
          // error: method not defined
          console.error("No such method '" + options + "' for " + pluginName);
        } else {
          // finally call the desired method
          instance[options].call(instance);
        }
      });
    } else {
      return this.each(function () {
        if (!$.data(this, "plugin_" + pluginName)) {
          $.data(this, "plugin_" + pluginName,
            new TextileToolbar( this, options ));
        }
      });
    }
  };

}( jQuery, window, document ));