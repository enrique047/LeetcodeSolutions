String Matching in an Array
class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        Set<String> st = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){

                if(i != j && words[i].contains(words[j])){
                    if(!st.contains(words[j])){
                        st.add(words[j]);
                    }
                }
            }
        }

        return new ArrayList<>(st);
    }
}