//Minimize XOR
class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] x = new int[1];
        x[0] = num1;

        int requiredBit = Integer.bitCount(num2);
        int currentCnt = Integer.bitCount(x[0]);
        int bit = 0;

        if(currentCnt < requiredBit){
            while(currentCnt < requiredBit){
                if(!isSet(x , bit)){
                    setBit(x , bit);
                    currentCnt++;
                }
                bit++;
            }
        }else if(currentCnt > requiredBit){
            while(currentCnt > requiredBit){
                if(isSet(x , bit)){
                    unsetBit(x , bit);
                    currentCnt--;
                }
                bit++;
            }
        }

        return x[0];
    }

    public boolean isSet(int[] x , int bit){
        return (x[0] & (1 << bit)) != 0;
    }

    public void setBit(int[] x , int bit){
        x[0] = x[0] | (1 << bit);
    }

    public void unsetBit(int[] x , int bit){
        x[0] = x[0] & ~(1 << bit);
    }
}