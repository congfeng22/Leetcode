import java.util.*;

public class WordLadder127 {
    HashMap<String,List<String>> graph = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        // init graph
        for (String s : wordList) {
            List<String> nb = new ArrayList<>();
            graph.put(s, nb);
        }
        for (int i=0;i<wordList.size()-1;i++) {
            for (int j=i+1;j<wordList.size();j++){
                if (dist(wordList.get(i),wordList.get(j))==1){
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        // minimum length of path from closest word to beginWord in 'graph' to endWord
        int minlen = Integer.MAX_VALUE;
        if (!graph.containsKey(beginWord)){
            for (String s:graph.keySet()){
                if (dist(beginWord,s)!=1) continue;
                minlen = Math.min(minlen,minlen(s,endWord));
                if (minlen==-1) return 0;
            }
            return minlen+1;
        } else {
            minlen = minlen(beginWord,endWord);
            if (minlen==-1) return 0;
            return minlen;
        }

    }
    public int minlen(String beginword, String endword){
        if (beginword.equals(endword)) return 1;
        Set<String> done = new HashSet<>();
        Set<String> process1 = new HashSet<>();
        Set<String> process2 = new HashSet<>();
        process1.add(beginword);
        int ret = 2;
        while (true){
            for (String i:process1){
                process2.addAll(graph.get(i));
            }
            if (process2.contains(endword)) break;
            done.addAll(process1);
            process1.clear();
            process2.removeAll(done);
            if (process2.size()==0) return -1;
            process1.addAll(process2);
            process2.clear();
            ret++;
        }
        return ret;
    }
    public int dist(String s, String t){
        int ret = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!=t.charAt(i)) ret++;
        }
        return ret;
    }
    public static void main(String[] args){
        WordLadder127 test = new WordLadder127();
        String s = "hit";
        String t = "cog";
        String[] temp = {"hot","dot","dog","lot","log","cog"};
        List<String> l = new ArrayList<>(Arrays.asList(temp));
        System.out.println(test.ladderLength(s,t,l));
    }
}
