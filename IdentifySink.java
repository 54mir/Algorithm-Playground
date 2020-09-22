class IdentifySink {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1)
            return 1;


        int[] trustValues = new int[N + 1];

        for (int i = 0; i < trust.length; i++){
            trustValues[trust[i][0]]--;
            trustValues[trust[i][1]]++;
        }

        for (int i = 0; i < trustValues.length; i++){
            if (trustValues[i] == N - 1) return i;
        }

        return -1;

    }
}