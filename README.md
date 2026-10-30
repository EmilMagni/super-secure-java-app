# super-secure-java-app

The most secure Java app in Denmark. Probably. 🔒

**Not actually secure. Vulnerable on purpose** for an IBM Concert Protect demo. Do not deploy outside a demo environment.

## What's wrong with it

`pom.xml` previously pinned `log4j-core` and `log4j-api` to **2.14.1**, which was affected by Log4Shell:

- CVE-2021-44228 (critical, remote code execution)
- CVE-2021-45046, CVE-2021-45105, CVE-2021-44832 (the follow-ups)

The finding lives in the code (a declared dependency), so a repository scan catches it before anything is built or deployed.

## The fix

One line in `pom.xml`:

```xml
<log4j.version>2.26.1</log4j.version>
```

(2.17.1 already clears the critical Log4Shell CVEs; 2.26.1 is the latest 2.x release and clears all 9 known log4j findings including CVE-2026-49844, CVE-2026-34477, CVE-2026-34479, CVE-2026-34480). Push, and the Grype gate in `.github/workflows/grype.yml` goes green.

## Demo flow

1. Connect this repo to IBM Concert (GitHub integration).
2. Show Log4Shell found in `pom.xml`, prioritized against the app.
3. Fix the version (for example with IBM Bob), push, and rescan. The CVE closes.
