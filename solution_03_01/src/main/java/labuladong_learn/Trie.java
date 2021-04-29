package labuladong_learn;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/27 10:15
 *
 * @Classname Trie
 * Description: 前缀树的实现
 */

/**
 *
 */
public class Trie {
    public static class TrieNode {
        int count; //以当前单词结尾的单词数量
        int prefix;//以该节点之前的字符串为前缀的单词数量
        TrieNode[] nextNode=new TrieNode[26];
        public TrieNode(){
            count=0;
            prefix=0;
        }
    }
    //前缀树的创建
    public static void insert(TrieNode root,String str){
        if (root == null || str.length() == 0){
            return;
        }
        char[] c = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            //如果该分支不存在，创建一个新节点
            if (root.nextNode[c[i] - 'a'] == null){
                root.nextNode[c[i] - 'a'] = new TrieNode();
            }
            root = root.nextNode[c[i] - 'a'];
            root.prefix++;
        }
        root.count++;
    }
    //查询以str开头的单词数量，查询单词str的数量
    //查找该单词是否存在，如果存在返回数量，不存在返回-1
    public static int search(TrieNode root,String str){
        if(root==null||str.length()==0){
            return -1;
        }
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
            //如果该分支不存在，表名该单词不存在
            if(root.nextNode[c[i]-'a']==null){
                return -1;
            }
            //如果存在，则继续向下遍历
            root=root.nextNode[c[i]-'a'];
        }

        //如果count==0,也说明该单词不存在
        if(root.count==0){
            return -1;
        }
        return root.count;
    }

    //查询以str为前缀的单词数量
    public static int searchPrefix(TrieNode root,String str){
        if(root==null||str.length()==0){
            return -1;
        }
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
            //如果该分支不存在，表名该单词不存在
            if(root.nextNode[c[i]-'a']==null){
                return -1;
            }
            //如果存在，则继续向下遍历
            root=root.nextNode[c[i]-'a'];
        }
        return root.prefix;
    }

    public static void main(String[] args) {
        TrieNode newNode=new TrieNode();
        insert(newNode,"hello");
        insert(newNode,"hello");
        insert(newNode,"hello");
        insert(newNode,"helloworld");
        System.out.println(search(newNode,"hello"));
        System.out.println(searchPrefix(newNode,"he"));
    }

}
