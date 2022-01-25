### start at January 26, 2022

组合模式: allows you to compose objects into tree structures to
    represent part-whole hierarchies. Composite lets clients treat 
    individual objects and compositions of object uniformly.
重点在最后一句……子类（调用者）可以无需考虑具体的方法适不适用，以及类型的强制转换，
直接使用组合对象——如果对象是节点（叶子，没有包含其他节点），那么调用不应该由它来实现的方法时，
可以抛出异常，或者提示错误的信息。这么说来还是挺好用的。
