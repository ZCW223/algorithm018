package Week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词（亚马逊、Facebook、谷歌在半年内面试中考过）*/
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 👍 268 👎 0
public class _1ValidAnagram {
    public static void main(String[] args) {
        // for test
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";
        System.out.println(s1+"\t"+t1+"\t"+"Is Valid Anagram ?\t:"+isAnagram01(s1,t1));
        System.out.println(s2+"\t"+t2+"\t"+"Is Valid Anagram ?\t:"+isAnagram01(s2,t2));
    }
    //1.暴力 统计数组 + 两重循环
    public static boolean isAnagram01(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] table = new int[26];//仅支持小写
        for(int i=0; i<s.length(); i++){
            table[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            table[t.charAt(i)-'a']--;
            if(table[t.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }
    //2.暴力 直接sort
    public static boolean isAnagram02(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }

    //3.使用哈希表——两重循环、先输入统计s中每个字母个数，再通过t对每个键值对中的值进行判断为0则删除键值对，最后判空
    public static boolean isAnagram03(String s,String t){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch: t.toCharArray()){
            Integer count = map.get(ch);
            if(count == null){
                return false;
            }else if(count > 1){
                map.put(ch,count - 1);
            }else{
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}
