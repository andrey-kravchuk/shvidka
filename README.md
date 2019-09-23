# Java Spring STFL Back Project
## Local run
```sh
$ docker build . -t stfl.back
$ docker-compose up --force-recreate

# If you want to run only database
$ docker-compose -f docker-compose-db.yml up
```
## Local config
> To create config variables create a copy variables.env.default with name variable.env. Every variable could be updated

### For the single database running

| CONFIG VARIABLE | CONFIG VALUE |
| ------ | ------ |
| MYSQL_HOST | localhost |
| MYSQL_PORT | 3306 |
| MYSQL_USER | root |
| MYSQL_PASSWORD | example |
| MYSQL_DATABASE | stfl |

### For compose running

| CONFIG VARIABLE | CONFIG VALUE |
| ------ | ------ |
| MYSQL_HOST | mysql |
| MYSQL_USER | root |
| MYSQL_PASSWORD | example |
| MYSQL_DATABASE | stfl |