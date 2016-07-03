/*
 * Copyright 2015-2016 Erlu Shang (sel8616@gmail.com/philshang@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.sel.dvw.test;

import cn.sel.dvw.annotation.MProperty;

import java.util.Date;

public class User1
{
    @MProperty
    public long id;
    @MProperty
    public String account;
    @MProperty(db_col_name = "account")
    public String username;
    @MProperty
    public String password;
    @MProperty
    public String name;
    @MProperty(db_col_name = "name")
    public String name1;
    @MProperty
    public String pid;
    public String phone;//Not annotated, but it can also be read.
    @MProperty(useSetter = true)
    public String email;//This field will be set using its setter.
    @MProperty
    private int status;
    @MProperty
    public Date create_datetime;
    @MProperty
    public Date access_datetime;

    @Override
    public String toString()
    {
        return "User1{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                ", pid='" + pid + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", create_datetime=" + create_datetime +
                ", access_datetime=" + access_datetime +
                '}';
    }

    public void setEmail(String email)
    {
        this.email = "email:" + email;
    }
}