import { Card} from "../components/index";
/**
 * You can register global components here and use them as a plugin in your main Vue instance
 */

const GlobalComponents = {
  install(Vue) {  
    Card
  }
};

export default GlobalComponents;
