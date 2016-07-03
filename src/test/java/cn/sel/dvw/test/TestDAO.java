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

import cn.sel.dvw.ObjectRowMapper;
import cn.sel.dvw.SimpleObjectRowMapper;
import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Map;

public class TestDAO extends JdbcDaoSupport
{
    public TestDAO()
    {
        BoneCPConfig config = new BoneCPConfig();
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cap_test?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUsername("appserver");
        dataSource.setPassword("1qazmlp0");
        dataSource.setDeregisterDriverOnClose(true);
        setDataSource(dataSource);
    }

    private static final String SQL_ERR = "SQL_ERR: ";
    private static final String SELECT_SINGLE = "SELECT * FROM `user` WHERE `phone`='13579246810'";
    private static final String SELECT_LIST = "SELECT * FROM `user`";

    public List<Map<String, Object>> getMapList()
    {
        String sql = SELECT_LIST;
        try
        {
            return getJdbcTemplate().queryForList(sql);
        } catch(DataAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUserListWithMapper()
    {
        try
        {
            String sql = SELECT_LIST;
            return getJdbcTemplate().query(sql, new ObjectRowMapper<User>()
            {
                @Override
                public void extend(User user)
                {
                    user.name += "_ext";
                }
            });
        } catch(DataAccessException e)
        {
            System.out.println(SQL_ERR + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUserListWithSimpleMapper()
    {
        try
        {
            String sql = SELECT_LIST;
            return getJdbcTemplate().query(sql, new SimpleObjectRowMapper<>(User.class));
        } catch(DataAccessException e)
        {
            System.out.println(SQL_ERR + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<User1> getUser1ListWithSimpleMapper()
    {
        try
        {
            String sql = SELECT_LIST;
            return getJdbcTemplate().query(sql, new SimpleObjectRowMapper<>(User1.class));
        } catch(DataAccessException e)
        {
            System.out.println(SQL_ERR + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}