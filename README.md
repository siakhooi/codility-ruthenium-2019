# Codility Challenge: <Challenge Name>

## <Task Name>

- Difficulty: <Difficulty>
- <Description>
- <challenge-url>
- <task-url>

## Versions

- Result
  - `Good`: Correctness 100%, Performance 100%.
  - `OK`: Correctness 100%, Performance <100%.
  - `Fail`: Correctness <100%, Performance <100%.
- File naming convention
  - Code `A`: `MayThe4th2021A.java`
  - Code `B`: `MayThe4th2021B.java`
  - etc

### Gold Award

| File | Complexity              | Result | Report                                                                            |
| ---- | ----------------------- | ------ | --------------------------------------------------------------------------------- |
| `A`  | `O(N*log(N))` or `O(N)` | `Good` | [3KMABZ](https://app.codility.com/cert/view/cert3KMABZ-DFKT9B4U8M83H9HB/details/) |

## Helper Code

```bash
java -cp target/classes nsh.codility.Challenge2021A
```

```java
	static void pf(String f, Object... v) {
		System.out.printf(f, v);
		System.out.println("");
	}
```

```java
	public static void main1(String argv[]) {
		String S = "eeeeedddddaadddcccccccrweioutpwoeriotuweoituebbbbbbaaaa";
		int K = 620;
		String E = "aaaaaabbbbbbcccccccddddddddeeeeeeeiorwutpworiotuweoitue";

		 String A = (new Challenge2021A()).solution(S, K);
		pf("     K: %d", K);
		pf("    in: %s", S);
		pf("   out: %s", A);
		pf("expert: %s", E);
		pf("Result: %s", (A.equals(E) ? "good" : "bad"));
	}
```
