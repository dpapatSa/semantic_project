import SideBar from "@/components/SidebarPlugin"; 
import GlobalComponents from "./globalComponents";
import GlobalDirectives from "./globalDirectives"; 

//css assets
import "@/assets/sass/main.scss";
import "@/assets/css/nucleo-icons.css"; 

export default {
  install(Vue) {
    Vue.use(GlobalComponents);
    Vue.use(GlobalDirectives);
    Vue.use(SideBar); 
  }
}
