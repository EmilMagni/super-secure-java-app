# super-secure-java-app

The most secure Java app in Denmark. Probably. 🔒

**Not actually secure. Vulnerable on purpose** for an IBM Concert Protect demo. Do not deploy outside a demo environment.

## What's wrong with it

`pom.xml` pins `log4j-core` and `log4j-api` to **2.14.1**, which is affected by Log4Shell:

- CVE-2021-44228 (critical, remote code execution)
- CVE-2021-45046, CVE-2021-45105, CVE-2021-44832 (the follow-ups)

The finding lives in the code (a declared dependency), so a repository scan catches it before anything is built or deployed.

## The fix

One line in `pom.xml`:

```xml
<log4j.version>2.25.5</log4j.version>
```

(2.17.1 already clears the critical Log4Shell CVEs; 2.25.5 clears every known log4j finding). Push, and the Grype gate in `.github/workflows/grype.yml` goes green.

## Demo flow

1. Connect this repo to IBM Concert (GitHub integration).
2. Show Log4Shell found in `pom.xml`, prioritized against the app.
3. Fix the version (for example with IBM Bob), push, and rescan. The CVE closes.
