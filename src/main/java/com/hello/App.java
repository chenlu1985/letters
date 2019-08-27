package com.hello;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args) {
        //暂时不考虑这种重复的情况
        /*System.out.println(convertDigitArr2Letters(new Integer[]{3 ,3 }));*/


        System.out.println(convertDigitArr2Letters(new Integer[]{3 ,2, 8, 4 }));
        System.out.println(convertDigitArr2Letters(new Integer[]{ 0, 1}));
        System.out.println(convertDigitArr2Letters(new Integer[]{ 9}));
        System.out.println(convertDigitArr2Letters(new Integer[]{2 ,3 }));

        System.out.println(convertDigitArr2Letters(new Integer[]{1, 2 ,3 }));
        System.out.println(convertDigitArr2Letters(new Integer[]{ 3 , 5, 7, 8 ,9}));
        System.out.println(convertDigitArr2Letters(new Integer[]{ 1,2,3,4,5,6,7,8,9}));
    }

    static String[] lettersArr = new String[] {
            "",// 0
            "",// 1
            "A,B,C",// 2
            "D,E,F",// 3
            "G,H,I",// 4
            "J,K,L",// 5
            "M,N,O",// 6
            "P,O,R,S",// 7
            "T,U,V",// 8
            "W,X,Y,Z"};//9


    private static List<Integer> sortArr(Integer[] arr){
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return list;
    }
    /**
     *
     * @param arr 要转换成字母组合的整数数组
     * @return 返回字母组合
     */
    public static List<String> convertDigitArr2Letters(Integer[] arr ){

        //对数组进行一下排序
        List<Integer> arrList = sortArr(arr);

        List<String> lettersList = new ArrayList<String>();
        for(Integer digit : arrList){
            String str = lettersArr[digit];
            if(!"".equals(str)){
                lettersList.add(str);
            }

        }
        if(lettersList.size()==0){
            return  null;
        }
        if(lettersList.size()==1){
            return  Arrays.asList(lettersList.get(0).split(","));
        }

        List <String> result = new ArrayList<String>();
        String preLetter = null;
        for(String letters: lettersList){
            if(preLetter==null){
                preLetter = letters;
                continue;
            }
            String[] preLetterArr = null;
            if(result.isEmpty()){
                preLetterArr =  preLetter.split(",");
            }else{
                preLetterArr = result.toArray(new String[0]);
            }

            String[] letter =  letters.split(",");

            for(String str1: preLetterArr){
                for(String str2: letter){
                    result.add(str1+str2);
                }
            }
            result.removeAll(Arrays.asList(preLetterArr));// 删除掉之前的元素
        }

        return result;
    }
}
