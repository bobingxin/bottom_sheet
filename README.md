# bottom_sheet android底部弹框

### 使用指南
#### 开发包的导入
>step1

    allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
 	
 >step2
 
    dependencies {
        compile 'com.github.bobingxin:bottom_sheet:0.0.1'
    }

#### 使用方法

1. 继承BottomSheetFragment实现下面两个方法
```
    //自定义底部弹框的layout
    @Override
    protected View getCustomView() {
        return setCustomView(R.layout.bottom_sheet);
    }
    
    //自定义底部弹框的事件
    @Override
    protected void setListener(View view) {
        view.findViewById(R.id.takePhoto).setOnClickListener(this);
        view.findViewById(R.id.choosePhoto).setOnClickListener(this);
    }
```
2. 点击事件的处理需要自己定义一个interface来对外开放