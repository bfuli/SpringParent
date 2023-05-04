package org.fuli.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    @Update("update tb_account set money=money+#{value} where account_name=#{accountName}")
    void increMoney(@Param("accountName") String accountName, @Param("value") double value);

    @Update("update tb_account set money=money-#{value} where account_name=#{accountName}")
    void decreMoney(@Param("accountName") String accountName, @Param("value") double value);
}
