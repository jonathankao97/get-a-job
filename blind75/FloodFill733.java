public class FloodFill733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] cards = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        int oldColor = image[sr][sc];
        visited[sr][sc] = 1;
        image[sr][sc] = color;
        while (q.size() != 0) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            for (int[] card : cards) {
                int nextX = currX + card[0];
                int nextY = currY + card[1];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && visited[nextX][nextY] == 0
                        && image[nextX][nextY] == oldColor) {
                    visited[nextX][nextY] = 1;
                    q.add(new int[] { nextX, nextY });
                    image[nextX][nextY] = color;
                }
            }
        }
        return image;
    }
}