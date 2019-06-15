Android LayoutInflater原理分析，带你一步步深入了解View(一)

LayoutInflater主要作用：
加载布局（对比通常使用的方法：在Activity()中调用setContentView()方法）。


LayoutInflater的基本用法
1.	获取LayoutInflater的实例；
    方法一：LayoutInflater layoutInflater = LayoutInflater.from(context);
    方法二：LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   （方法一是方法二的简单写法，Android为我们封装简化了方法二的表达）

2.	调用它的inflate()方法来加载布局，创建布局实例
    layoutInflater.inflate(resourceId, root);
	/**
	 *@param resourceId 要加载的布局id
	 *@param root 给该布局的外部再嵌套一层父布局，如果不需要就直接传入null
	 */
	 public ***** inflate(*********) {}









