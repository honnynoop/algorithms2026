#include <iostream>

using namespace std;

int map[1001][1001], n, visited[1001], order[1001];

int search(int x, int depth){
    //cout << x << " " << depth << "\n";
    if (depth == n - 1){
        order[depth] = x;
        return 1;
    }
    for (int i = 0; i < n; i++){
        if (map[x][i] == 1 && visited[i] == 0){
            visited[i] = 1;
            order[depth + 1] = i;
            if (search(i, depth + 1)) return 1;
            order[depth + 1] = -1;
            visited[i] = 0;
        }
    }
    return 0;
}

void outer_search(){
    for (int i = 0; i < n; i++){
        visited[i] = 1;
        order[0] = i;
        if (search(i, 0)) return;
        cout << "\n";
        visited[i] = 0;
    }
}

int main(){
    ios::sync_with_stdio(false);
	cin.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++) visited[i] = 0;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++) cin >> map[i][j];
    }

    outer_search();
    cout << 1 << "\n" << n << " ";
    for (int i = 0; i < n; i++) cout << order[i] + 1 << " ";

    return 0;
}