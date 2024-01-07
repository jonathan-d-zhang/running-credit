# running-credit
Goal: Try to police the amount of money I spend by limiting it to a multiple of how
many miles I've run.

# To run
First decrypt the config with sops
```shell
$ sops -d secrets.enc.yaml > application.yaml
```

Then run with gradle
```shell
$ ./gradlew bootRun
```
