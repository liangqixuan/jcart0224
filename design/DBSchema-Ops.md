# ProductOperation
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| product_id  | int  | 外键 | Id           |
| all_count   | int  | 非空 | 所有访问次数  |
| day_count   | int  | 非空 | 最近访问时间  |
| recent_time | datetime| 非空 | 时间      |