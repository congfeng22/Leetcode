import java.util.*;

public class WordLadderII126 {
    HashMap<String,List<String>> graph = new HashMap<>();
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return ret;
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
                if (minlen==-1) return ret;
            }
            // add all shortest paths to ret;
            for (String s:graph.keySet()){
                if (dist(beginWord,s)!=1) continue;
                getpath(s,endWord,minlen, beginWord+" "+s);
            }
            return ret;
        } else {
            minlen = Math.min(minlen,minlen(beginWord,endWord));
            getpath(beginWord,endWord,minlen, beginWord);
            return ret;
        }

    }
    public void getpath(String beginword, String endword, int len, String path){
        if (len==0){
            if (beginword.equals(endword)) {
                ret.add(Arrays.asList(path.split(" ")));
                return;
            }
            else return;
        }
        for (String s:graph.get(beginword)){
            if (minlen(s,endword)==len-1) getpath(s,endword,len-1,path+" "+s);
        }
    }
    public int minlen(String beginword, String endword){
        if (beginword.equals(endword)) return 0;
        Set<String> done = new HashSet<>();
        Set<String> process1 = new HashSet<>();
        Set<String> process2 = new HashSet<>();
        process1.add(beginword);
        int ret = 1;
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
        WordLadderII126 test = new WordLadderII126();
        String s = "cet";
        String t = "ism";
        String[] temp = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        List<String> l = new ArrayList<>(Arrays.asList(temp));
        List<List<String>> pr = test.findLadders(s,t,l);
        System.out.println(pr.toString());
    }
}