export class Catalog {
  id: number;
  catalogName: string;
  deparments: Array<Department>;
  constructor() {
  }
}

export interface Department {
  deptId: number;
  departmentName: string;
  subdepartments: Array<Subdepartment>;
}

export interface Subdepartment {
  subDeptId: number;
  subDepartmentName: string;
  products: Array<Product>;
}

export interface Product {
  prdId: number;
  productName: string;
  price: number;
  quantity: number;
}
