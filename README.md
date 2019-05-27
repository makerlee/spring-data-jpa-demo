### spring-data-jpa实现dao层封装

1.UserHandler利用spring jpa 实现了mysql悲观锁,对 读取->操作->更新 这类多线程同步问题进行了保证

2.不考虑分布式的情况下, 可以用乐观锁替代悲观锁，提高并发时的性能
