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

import cn.sel.jutil.lang.Stringer;

import java.util.logging.Logger;

public class MapperTest
{
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String... args)
    {
        TestDAO dao = new TestDAO();
        LOGGER.info("1-------------------------------------------------------------------------");
        LOGGER.info(Stringer.list2String(dao.getMapList()));
        LOGGER.info("2-------------------------------------------------------------------------");
        LOGGER.info(Stringer.list2String(dao.getUserListWithMapper()));
        LOGGER.info("3-------------------------------------------------------------------------");
        LOGGER.info(Stringer.list2String(dao.getUserListWithSimpleMapper()));
        LOGGER.info("4-------------------------------------------------------------------------");
        LOGGER.info(Stringer.list2String(dao.getUser1ListWithSimpleMapper()));
    }
}