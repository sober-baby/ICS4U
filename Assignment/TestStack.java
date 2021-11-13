package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.stream.events.EndElement;
import GUI.FlowLayoutDemo;

public class TestStack {

    public static Stack<pair> stack = new Stack<pair>();
    public static char[][] grid = { { 'B', 'B', 'B', 'B' }, { 'E', 'O', 'O', 'B' }, { 'B', 'O', 'O', 'B' },
            { 'B', 'O', 'S', 'B' } };
    public static int sx = 3, sy = 2, ex = 1, ey = 0;
    public static boolean[][] vis = new boolean[grid.length][grid[0].length];
    public static int mx[] = { 0, 0, 1, -1 }, my[] = { 1, -1, 0, 0 };

public static void fun(int x, int y) {
    if (x == ex && y == ey) {
        Stack<pair> tmp = stack;
        while (!tmp.empty()) {
            int pathx = tmp.peek().first;
            int pathy = tmp.peek().second;
            grid[pathx][pathy] = '+';
            tmp.pop();
        }
        if(!stack.isEmpty())
            {
                stack.pop();
            }
        return;
    }
    
    for (int i = 0; i < 4; i++) {
        int dx = x+mx[i], dy = y+my[i];
        if (dx >= 0 && dx <= 3 && dy >= 0 && dy <= 3 && !vis[dx][dy] && grid[dx][dy] != 'B') {
            vis[dx][dy] = true;
            st.push({dx, dy});
            fun(dx, dy);
        }
    }
    st.pop();
    return;
}

int main() {
    vis[sx][sy] = true;
    st.push({sx, sy});
    fun(sx, sy);
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cout << grid[i][j] << " ";
        }
        cout << endl;
    }
 
    return 0;
}

}
