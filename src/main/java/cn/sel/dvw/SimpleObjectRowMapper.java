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

import cn.sel.dvw.annotation.MProperty;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Implementation of org.springframework.jdbc.core.RowMapper.<br/>
 * Use this class like this:<br/>
 * <code>List<User> list = jdbcTemplate.query("SELECT * FROM T_USER WHERE ...", new SimpleObjectRowMapper<User>(User.class), args...);</code>
 */
public class SimpleObjectRowMapper<T> implements RowMapper<T>
{
    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public SimpleObjectRowMapper(Class<T> clazz)
    {
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
    }

    @Override
    public T mapRow(ResultSet resultSet, int rowNum) throws SQLException
    {
        T rowObj;
        try
        {
            rowObj = clazz.getConstructor().newInstance();
        } catch(InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            throw new SQLException("Failed to instantiate the result object!", e);
        }
        Field[] fields = clazz.getFields();
        for(Field field : fields)
        {
            MProperty annotation = field.getAnnotation(MProperty.class);
            String fieldName = field.getName();
            String columnName = null;
            boolean useSetter = false;
            if(annotation != null)
            {
                columnName = annotation.db_col_name();
                useSetter = annotation.useSetter();
            }
            if(columnName == null || columnName.isEmpty())
            {
                columnName = fieldName;
            }
            Object value = resultSet.getObject(columnName);
            if(value != null)
            {
                try
                {
                    if(useSetter)
                    {
                        PropertyUtils.setSimpleProperty(rowObj, fieldName, value);
                    } else
                    {
                        field.setAccessible(true);
                        field.set(rowObj, value);
                    }
                } catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
                {
                    e.printStackTrace();
                    throw new SQLException(String.format("Failed to set value for property '%s'!", fieldName));
                }
            }
        }
        return rowObj;
    }
}