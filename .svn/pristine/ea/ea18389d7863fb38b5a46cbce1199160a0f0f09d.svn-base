//自定义Overlay类，类似Marker，但比Marker复杂
function ClusterMarker(point, text, opt_options){           
    this.text = text;
    this.point = point;
    
    var options = opt_options || {};
    this.styles = options["styles"] || [];
    if(this.styles.length == 0){
        this._setupDefaultStyles();       
    }
    
    this.bounds = options["bounds"] || null;
}

ClusterMarker.prototype = new BMap.Overlay(); 
ClusterMarker.prototype.IMAGE_PATH = 'images/m';
ClusterMarker.prototype.IMAGE_EXTENSION  = 'png';

ClusterMarker.prototype.initialize = function(map){
    this.map = map;
    
    this.div = document.createElement('div');     
    this._updateCss();    
    this.__updateText();
    this._updatePoint();
    
    var that = this;
    this.div.onclick = function(event){
        that._clickHandler(event);
        if(that.bounds){
           that.fitBounds(that.map, that.bounds);
        }
    };
    
    map.getPanes().markerMouseTarget.appendChild(this.div);
    return this.div;   
};

ClusterMarker.prototype.fitBounds = function(map, bounds){
    map.setViewport([new BMap.Point(bounds.maxX, bounds.maxY),
            new BMap.Point(bounds.maxX, bounds.minY),
            new BMap.Point(bounds.minX, bounds.maxY),
            new BMap.Point(bounds.minX, bounds.minY)
        ]);//BUG 不会触发zoom或move的change事件
    map.zoomIn();
    map.zoomOut();
};//对Baidu.Map的扩展

ClusterMarker.prototype.draw = function(){
     this._updatePoint();
};

ClusterMarker.prototype.getText = function(){
    return this.text;
};
ClusterMarker.prototype.setText = function(text){
    if(text && (!this.text || (this.text.toString() != text.toString()))){
        this.text = text;
        this.__updateText();
        this._updateCss();
        this._updatePoint(); 
    }
};

ClusterMarker.prototype.getPoint= function(){
    return this.point;
};
ClusterMarker.prototype.setPoint= function(point){
    if(point && (!this.point || !this.point.equals(point))){
        this.point = point;  
        this._updatePoint();
    }
};

ClusterMarker.prototype._calculator = function(text, stylesLength){

    return 0;
};
ClusterMarker.prototype.setCalculator = function(calculator) {
    this._calculator = calculator;
};
ClusterMarker.prototype.getCalculator = function() {
    return this._calculator;
};

ClusterMarker.prototype.setBounds = function(bounds) {
    this.bounds = bounds;
};
ClusterMarker.prototype.getBounds = function() {
    return this.bounds;
};

ClusterMarker.prototype._clickHandler = function(event){
};
ClusterMarker.prototype.addEventListener = function(type, handler){
    if(type === "click"){
        this._clickHandler = handler;
    }
};

//更新文字的"CSS"
ClusterMarker.prototype.__updateText = function(){
    if (this.div) {
        this.div.innerHTML = this.text;
    }
};
//更新位置信息的CSS
ClusterMarker.prototype._updatePoint = function(){
    if (this.div && this.point) {
        var pixelPosition= this.map.pointToOverlayPixel(this.point); 
        pixelPosition.x -= parseInt(this.width / 2, 10);
        pixelPosition.y -= parseInt(this.height / 2, 10);
        this.div.style.left = pixelPosition.x + "px";
        this.div.style.top = pixelPosition.y + "px";
    }
};
//更新不含位置信息的CSS，也即没有设置top left
ClusterMarker.prototype._updateCss = function(){
    var styleIndex = this.getCalculator()(this.text,this.styles.length);
    var css = this._buildCssText(styleIndex);
    this.div.style.cssText = css;
};

ClusterMarker.prototype._setupDefaultStyles = function(){  
    this.sizes = [53, 56, 66, 78, 90];
    this.imagePath = this.IMAGE_PATH;
    this.imageExtension = this.IMAGE_EXTENSION;
    for(var i = 0, size; size = this.sizes[i]; i++){
        this.styles.push({
            url:this.imagePath + i + '.' + this.imageExtension,
            height:size,
            width:size
        });
    }
};

ClusterMarker.prototype._buildStyle = function(index) {
    index = Math.max(0, index);
    index = Math.min(this.styles.length - 1, index);
    var style = this.styles[index];
    this.url = style['url'];
    this.height = style['height'];
    this.width = style['width'];
    this.anchor = style['anchor'];
    this.textColor = style['textColor'];
    this.textSize = style['textSize'];
    this.backgroundPosition = style['backgroundPosition'];
};

ClusterMarker.prototype._buildCssText = function(index) {    
    this._buildStyle(index);
    var csstext = [];
    if (document.all) {
        csstext.push('filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(' +
            'sizingMethod=scale,src="' + this.url + '");');
    } else {
        csstext.push('background-image:url(' + this.url + ');');
        var backgroundPosition = this.backgroundPosition ? this.backgroundPosition : '0 0';
        csstext.push('background-position:' + backgroundPosition + ';');
    }

    if (typeof this.anchor === 'object') {
        if (typeof this.anchor[0] === 'number' && this.anchor[0] > 0 &&
            this.anchor[0] < this.height_) {
              csstext.push('height:' + (this.height - this.anchor[0]) +
                  'px; padding-top:' + this.anchor[0] + 'px;');
    } else {
        csstext.push('height:' + this.height + 'px; line-height:' + this.height + 'px;');
    }
    if (typeof this.anchor[1] === 'number' && this.anchor[1] > 0 && this.anchor[1] < this.width) {
        csstext.push('width:' + (this.width - this.anchor[1]) + 'px; padding-left:' + this.anchor[1] + 'px;');
    } else {
        csstext.push('width:' + this.width + 'px; text-align:center;');
    }
    } else {
        csstext.push('height:' + this.height + 'px; line-height:' +
            17 + 'px; width:' + this.width + 'px; text-align:center;');
    }

    var txtColor = this.textColor ? this.textColor : 'black';
    var txtSize = this.textSize ? this.textSize : 11;
    
    csstext.push('cursor:pointer; color:' + txtColor + '; position:absolute; font-size:' +
        txtSize + 'px; font-family:Arial,sans-serif; font-weight:400');
    return csstext.join('');
};