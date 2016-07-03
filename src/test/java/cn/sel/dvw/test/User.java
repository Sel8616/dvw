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

import java.util.Date;

public class User
{
    //Any field's visibility will be ignored if it has no public setter.
    private long id;
    private String account;
    protected String password;
    public String name;
    protected String pid;
    public String phone;
    public String email;
    private int status;
    public Date create_datetime;
    public Date access_datetime;

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", create_datetime=" + create_datetime +
                ", access_datetime=" + access_datetime +
                '}';
    }
}