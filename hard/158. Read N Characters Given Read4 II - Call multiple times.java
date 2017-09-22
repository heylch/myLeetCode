public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private List<Character> mainBuffer = new ArrayList<Character>();
    private int totalReadBytes = 0;
    
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        while (readBytes < n && !endOfFile) {
            int currReadBytes = read4(buffer);
            for(int i = 0; i < currReadBytes; i++)
                mainBuffer.add(buffer[i]);
            if (currReadBytes !=4) {
                endOfFile = true;
            }
            int length = Math.min(n - readBytes, mainBuffer.size() - totalReadBytes);
            for (int i=0; i<length; i++) {
                System.out.println(mainBuffer.get(totalReadBytes +i));
                buf[readBytes + i] = mainBuffer.get(totalReadBytes +i);
            }
            readBytes += length;
            totalReadBytes += length;
        }
        return readBytes;
    }
}