Android LayoutInflaterԭ�����������һ���������˽�View(һ)

LayoutInflater��Ҫ���ã�
���ز��֣��Ա�ͨ��ʹ�õķ�������Activity()�е���setContentView()��������


LayoutInflater�Ļ����÷�
1.	��ȡLayoutInflater��ʵ����
    ����һ��LayoutInflater layoutInflater = LayoutInflater.from(context);
    ��������LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   ������һ�Ƿ������ļ�д����AndroidΪ���Ƿ�װ���˷������ı�

2.	��������inflate()���������ز��֣���������ʵ��
    layoutInflater.inflate(resourceId, root);
	/**
	 *@param resourceId Ҫ���صĲ���id
	 *@param root ���ò��ֵ��ⲿ��Ƕ��һ�㸸���֣��������Ҫ��ֱ�Ӵ���null
	 */
	 public ***** inflate(*********) {}









