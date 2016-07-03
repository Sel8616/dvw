# dvw

### ⿻ About
***
A third-part mapper for spring-jdbc.

#### Dependency Config

|groupId|artifactId|version|
|:-----:|:--------:|:-----:|
|cn.sel |dvw       |0.1    |

[![Download](https://api.bintray.com/packages/sel8616/maven/dvw/images/download.svg)](https://bintray.com/sel8616/maven/dvw/_latestVersion)


### ☞ Guides
***
>Special characters ( ＠:Annotation ⓒ:Normal Class ⓐ：Abstract Class )

#### Mapping rules:
|Field Status|Corresponding Column Name|
|:-----------|:------------------------|
|Annotated with ＠MProperty|Annotated Name: ＠MProperty#db_col_name()|
|Not Annotated / Null / Empty |Field Name|

>If the entities' names are as same as their corresponding db column names, then the annotations are redundant.

#### >> Query
* ⓐObjectRowMapper

```java
ObjectRowMapper mapper = new ObjectRowMapper<User>()
{
    @Override
    public void extend(User user)
    {
        // Do sth. as needed.
        return user; // This modified instance is the actual result.
    }
};
List<User> list = jdbcTemplate.query(sql, mapper, args...);
```

* ⓒSimpleObjectRowMapper

```java
List<User> list = jdbcTemplate.query(sql, new SimpleObjectRowMapper<User>(User.class), args...);
```


See details in the src code
:p


### ☺ Contact
***
✉  sel8616@gmail.com || philshang@163.com

Ⓠ  117764756