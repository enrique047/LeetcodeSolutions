//Neighboring Bitwise XOR
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        int[] orig = new int[n];
        orig[0] = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            orig[i + 1] = orig[i] ^ derived[i];
        }

        if((orig[n - 1] ^ orig[0]) == derived[n-1]){
            return true;
        }

        orig[0] = 1;

        for(int i = 0 ; i < n - 1 ; i++){
            orig[i + 1] = orig[i] ^ derived[i];
        }

        if((orig[n - 1] ^ orig[0]) == derived[n-1]){
            return true;
        }

        return false;
    }
}