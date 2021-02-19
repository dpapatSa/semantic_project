import DashboardLayout from "@/layout/dashboard/DashboardLayout.vue";
// GeneralViews
import NotFound from "@/pages/NotFoundPage.vue"; 
 
const Home = () => import(/* webpackChunkName: "dashboard" */"@/pages/Home.vue");
const Metric1 = () => import(/* webpackChunkName: "dashboard" */"@/pages/Metric1.vue");
const Metric2 = () => import(/* webpackChunkName: "common" */ "@/pages/Metric2.vue");
const Metric3 = () => import(/* webpackChunkName: "common" */ "@/pages/Metric3.vue");
const Metric4 = () => import(/* webpackChunkName: "common" */ "@/pages/Metric4.vue");
const Metric5 = () => import(/* webpackChunkName: "common" */ "@/pages/Metric5.vue");
const Metric6 = () => import(/* webpackChunkName: "common" */ "@/pages/Metric6.vue");
const Statistics = () => import(/* webpackChunkName: "common" */ "@/pages/Statistics.vue");
const Pitfalls = () => import(/* webpackChunkName: "common" */ "@/pages/Pitfalls.vue");

const routes = [
  { path: "*", component: DashboardLayout },
  {
    path: "/",
    component: DashboardLayout, 
    children: [
      {
        path: "home",
        name: "Home",
        component: Home
      },
      {
        path: "metric1",
        name: "Metric: Size of Ontology",
        component: Metric1
      },   
      {
        path: "metric2",
        name: "Metric: Approprietness of Module Size",
        component: Metric2
      },   
      {
        path: "metric3",
        name: "Metric: Attribute Richness",
        component: Metric3
      },
      {
        path: "metric4",
        name: "Metric: Average Population",
        component: Metric4
      },
      {
        path: "metric5",
        name: "Metric: Last Class/Relation Ratio",
        component: Metric5
      },
      {
        path: "metric6",
        name: "Metric: Equivelents Ratio",
        component: Metric6
      },
      {
        path: "statistics",
        name: "Statistics",
        component: Statistics
      },
      {
        path: "pitfalls",
        name: "Pitfalls",
        component: Pitfalls
      },
      { path: "*", component: Home }
    ]
  },
];

/**
 * Asynchronously load view (Webpack Lazy loading compatible)
 * The specified component must be inside the Views folder
 * @param  {string} name  the filename (basename) of the view to load.
function view(name) {
   var res= require('../components/Dashboard/Views/' + name + '.vue');
   return res;
};**/

export default routes;
