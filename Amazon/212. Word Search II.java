class Solution {
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
		for (String s : words) {
			t.addString(s);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (t.root.children[board[i][j] - 'a'] != null) {
					dfs(i, j, board, t.root);
				}
			}
		}
		return result;
    }
    public  boolean isValid(int i, int j, char[][] board) {
		if(i < 0 || j < 0 || i >= board.length || j >=  board[0].length || board[i][j] == '#') {
			return false;
		}
		return true;
	}
    public  void dfs(int i, int j, char[][] board, TrieNode parent) {
		char l = board[i][j];
		TrieNode node = parent.children[board[i][j] - 'a'];
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		board[i][j] = '#';
		for (int[] n : neighbors) {
			int newi = i + n[0];
			int newj = j + n[1];
			if (isValid(newi, newj, board) && node.children[board[newi][newj] - 'a'] != null) {
				dfs(newi, newj, board, node);
			}
		}
		board[i][j] = l;
	}

	static int[][] neighbors = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
}

class TrieNode {
	char c;
	TrieNode[] children;
	String word;

	public TrieNode(char c) {
		this.c = c;
		this.children = new TrieNode[26];
	}

	public TrieNode() {
	};
}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode('$');
	}

	public void addString(String s) {
		TrieNode node = root;
		for (char c : s.toCharArray()) {
			if (node.children[c - 'a'] != null) {
				node = node.children[c - 'a'];
			} else {
				TrieNode n = new TrieNode(c);
				node.children[c - 'a'] = n;
				node = n;
			}
		}
		node.word = s;
	}
}
