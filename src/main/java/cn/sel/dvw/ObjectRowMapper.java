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
//endregion
package cn.sel.dvw;

import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of org.springframework.jdbc.core.RowMapper.<br/>
 * Use this class like this:<br/>
 * <code>List<User> list = jdbcTemplate.query("SELECT * FROM T_USER WHERE ...", mapper, args...);</code>
 */
public abstract class ObjectRowMapper<T> implements RowMapper<T>
{
    @SuppressWarnings("unchecked")
    private final SimpleObjectRowMapper<T> mapper = new SimpleObjectRowMapper<>((Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

    /**
     * Modify the result before it's returned for special purpose.<br/>
     *
     * @param t The mapped result.
     */
    protected abstract void extend(T t);

    @Override
    public T mapRow(ResultSet resultSet, int rowNum) throws SQLException
    {
        T rowObj = mapper.mapRow(resultSet, rowNum);
        extend(rowObj);
        return rowObj;
    }
}