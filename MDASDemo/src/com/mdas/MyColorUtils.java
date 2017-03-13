package com.mdas;

import java.awt.Color;
import java.util.HashMap;

/***
 * ��ɫ������
 * @author Administrator
 *
 */
public class MyColorUtils {
	public enum MyColor{MAIN_DARK,MAIN_GREY,MAIN_YELLOW,MAIN_GREY_PANEL,MAIN_DISABLE_FOR,MAIN_DISABLE_GROUND;}
	/***
	 * �洢��ɫ���ϣ���ʱʹ��
	 */
	private static final HashMap<MyColor,String> colorCollections = new HashMap<MyColor,String>(); 
	static {
		colorCollections.put(MyColor.MAIN_DARK, toHexFromColor(new Color(52, 52, 52)));
		colorCollections.put(MyColor.MAIN_GREY, toHexFromColor(new Color(80, 80, 80)));  
		colorCollections.put(MyColor.MAIN_YELLOW, toHexFromColor(new Color(243, 188, 61)));
		colorCollections.put(MyColor.MAIN_GREY_PANEL, toHexFromColor(new Color(64, 64, 64)));
		colorCollections.put(MyColor.MAIN_DISABLE_FOR, toHexFromColor(new Color(244, 244, 244)));
		colorCollections.put(MyColor.MAIN_DISABLE_GROUND, toHexFromColor(new Color(109, 109, 109)));
		
	}
	public static Color getColor(MyColor myColorType){
		if(myColorType != null){
			return toColorFromString(colorCollections.get(myColorType));
		}
		return null;
	}
	/** 
     * Color����ת�����ַ��� 
     * @param color Color���� 
     * @return 16������ɫ�ַ��� 
     * */  
    private static String toHexFromColor(Color color){  
        String r,g,b;  
        StringBuilder su = new StringBuilder();  
        r = Integer.toHexString(color.getRed());  
        g = Integer.toHexString(color.getGreen());  
        b = Integer.toHexString(color.getBlue());  
        r = r.length() == 1 ? "0" + r : r;  
        g = g.length() ==1 ? "0" +g : g;  
        b = b.length() == 1 ? "0" + b : b;  
        r = r.toUpperCase();  
        g = g.toUpperCase();  
        b = b.toUpperCase();  
        su.append("0xFF");  
        su.append(r);  
        su.append(g);  
        su.append(b);  
        //0xFF0000FF  
        return su.toString();  
    }  
    /** 
     * �ַ���ת����Color���� 
     * @param colorStr 16������ɫ�ַ��� 
     * @return Color���� 
     * */  
    private static Color toColorFromString(String colorStr){  
        colorStr = colorStr.substring(4);  
        Color color =  new Color(Integer.parseInt(colorStr, 16)) ;  
        return color;  
    }  
}
