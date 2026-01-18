import java.util.LinkedList;
import java.util.Queue;

//Last Day Where You Can Still Cross
class Solution {
    int R, C;
    int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int latestDayToCross(int row, int col, int[][] cells) {
        int res = 0;

        R = row;
        C = col;

        int start = 0, end = cells.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (bfs(mid, cells)) {
                res = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }

    public boolean bfs(int mid, int[][] cells) {
        Queue<int[]> q = new LinkedList<>();

        int[][] mat = new int[R][C];
        for (int x = 0; x <= mid; x++) {
            int i = cells[x][0] - 1;
            int j = cells[x][1] - 1;

            mat[i][j] = 1;
        }

        boolean[][] visited = new boolean[R][C];

        for (int j = 0; j < C; j++) {
            if (mat[0][j] == 0) {
                q.offer(new int[] { 0, j });
                visited[0][j] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] pts = q.poll();
            int x = pts[0];
            int y = pts[1];

            for (int[] d : dir) {
                int x_ = x + d[0];
                int y_ = y + d[1];

                if (x_ < 0 || y_ < 0 || x_ >= R || y_ >= C || visited[x_][y_] == true || mat[x_][y_] == 1) {
                    continue;
                }

                if (x_ == R - 1) {
                    return true;
                }

                q.offer(new int[] { x_, y_ });
                visited[x_][y_] = true;
            }
        }

        return false;
    }
}