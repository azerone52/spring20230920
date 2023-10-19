package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao5 {
    @Select("""
    <script>
        SELECT COUNT(*)
        FROM customers
        <if test='country != null'>
        WHERE Country = #{country}
        </if>
    </script>
    """)
    String select1(String country);
//     num < 10: 불가능-> '<' 태그 시작과 헷갈리므로
//    키워드 연산을 사용하여 num lt 10 은 가능
    @Select("""
    <script>
    SELECT CustomerName FROM customers
    <if test = 'num == 10'>
        -- 수가 10이다  
    </if>
    <if test = 'num != 10'>
        -- 수가 10이 아니다.
    </if>
    <if test = 'num > 10'>
        -- 수가 10보다 크다
    </if>
    <if test = '10 > num'>
        -- 수가 10보다 작다
    </if>
    <if test = 'num >= 10'>
        -- 수가 10보다 크거나 같다
    </if>
    <if test = 'num lte 10'>
        -- 수가 10보다 작거나 같다
    </if>
    </script>
    """)
    List<String> select2(Integer num);

    @Select("""
    <script>
    SELECT CustomerName, ContactName
    FROM customers
    <if test='code == 1'>
        WHERE CustomerName LIKE #{k}
    </if>
    <if test='code == 2'>
        WHERE ContactName LIKE #{k}
    </if>
    </script>
    """)
    List<Map<String, Objects>> select3(Integer code, String k);


    @Select("""
            <script>
                SELECT COUNT(*) FROM customers
                WHERE
                    <if test='i gt 10'>
                    -- i가 10보다 큼
                    </if>
                    <if test='i lt 10'>
                    -- i가 10보다 작음
                    </if>
                    <if test='(i gt 0) and (i lt 100)'>
                    -- i가 0보다 크고 100보다 작음
                    </if>
            </script>
            """)
    String select4(int i);
}
