package com.company;
import java.util.*;

class TrieNode {
    Map<String, TrieNode> map;

    boolean isFile;
    String content;
    public TrieNode() {
        this.isFile = false;
        this.map = new HashMap<>();
        this.content = "";
    }
    public void addContent(String content) {
        if(this.content.isEmpty()) {
            this.content = content;
        } else {
            this.content += content;
        }
    }
}

public class FileSystem {

    TrieNode root;
    public FileSystem() {
        this.root = new TrieNode();
    }

    public List<String> ls(String path) {
        // return all files under the path
        List<String> res = new ArrayList<>();
        String[] arr = path.split("/");
        TrieNode run = this.root;

        for(int i=0; i<arr.length; i++) {
            String cur = arr[i];
            if(cur.isEmpty()) {
                continue;
            }
            if(!run.map.containsKey(cur)) {
                return res;
            }
            run = run.map.get(cur);
        }
        if(run.isFile) {
            res.add(arr[arr.length-1]);
        } else {
            for(String key: run.map.keySet()) {
                res.add(key);
            }
            Collections.sort(res);
        }
        return res;

    }

    public void mkdir(String path) {
        String[] data = path.split("/");
        TrieNode run = this.root;

        for(int i=0; i<data.length; i++) {
            String cur = data[i];
            if(cur.isEmpty()) {
                continue;
            }
            if(!run.map.containsKey(cur)) {
                run.map.put(cur, new TrieNode());
            }
            run = run.map.get(cur);
        }
    }

    public void addContentToFile(String filePath, String content) {

        String[] data = filePath.split("/");
        TrieNode run = this.root;
        for(String each: data) {
            if(each.isEmpty()) {
                continue;
            }
            if(!run.map.containsKey(each)) {
                run.map.put(each, new TrieNode());
            }
            run = run.map.get(each);
        }
        run.addContent(content);
    }

    public String readContentFromFile(String filePath) {
        String[] data = filePath.split("/");
        TrieNode run = this.root;
        for(String each: data) {
            if(each.isEmpty()) {
                continue;
            }
            if(!run.map.containsKey(each)) {
                run.map.put(each, new TrieNode());
            }
            run = run.map.get(each);
        }
        return run.content;
    }
}

