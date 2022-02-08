package week6.Hash_functions;
class ETHHash extends HashTable {

    public ETHHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        // TODO
        if(item  == null)return 0;
        int n = item.length();
        int[] b = new int[n+1];
        b[0] = 1;
        for(int i=1;i<=n;i++){
            b[i] = item.charAt(i-1)* ((b[i-1]%257) + 1);
        }
        return b[n]%getCapacity();
    }
}

class GNUCPPHash extends HashTable {

    public GNUCPPHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        // TODO
        if(item  == null)return 0;
        int n = item.length();
        long[] b = new long[n+1];
        long mod = 1;
        for(int i=1;i<=31;i++)mod *=2;
        b[0] = 1;
        for(int i=1;i<=n;i++){
            b[i] = (item.charAt(i-1) + b[i-1]*4)%mod;
        }
        return (int)b[n]%getCapacity();
    }
}

class GNUCC1Hash extends HashTable {

    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        // TODO
        if(item  == null)return 0;
        int n = item.length();
        long[] b = new long[n+1];
        long mod = 1;
        for(int i=1;i<=30;i++)mod *=2;
        b[0] = n;
        for(int i=1;i<=n;i++){
            b[i] = (item.charAt(i-1) + b[i-1]*613)%mod;
        }
        return (int)b[n]%getCapacity();
    }
}

class HashCodeHash extends HashTable {

    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        // TODO
        if(item  == null)return 0;
        int code = Math.abs(item.hashCode())%getCapacity();
        return code;
    }
}