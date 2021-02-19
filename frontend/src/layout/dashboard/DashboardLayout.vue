<template>
  <div class="wrapper">
    <side-bar>
      <template slot="links">

        <sidebar-link
          to="/home"
          :name="$t('sidebar.Home')"
          icon="tim-icons icon-chart-pie-36"
        />
        <sidebar-link
          to="/metric1"
          :name="$t('sidebar.Metric1')"
          icon="tim-icons icon-atom"
        />
        <sidebar-link
          to="/metric2"
          :name="$t('sidebar.Metric2')" 
          icon="tim-icons icon-atom"
        />
        <sidebar-link
          to="/metric3"
          :name="$t('sidebar.Metric3')"
          icon="tim-icons icon-atom"
        />

        <sidebar-link
          to="/metric4"
          :name="$t('sidebar.Metric4')"
          icon="tim-icons icon-atom"
        />

        <sidebar-link
          to="/metric5"
          :name="$t('sidebar.Metric5')"
          icon="tim-icons icon-atom"
        />

        <sidebar-link
          to="/metric6"
          :name="$t('sidebar.Metric6')"
          icon="tim-icons icon-atom"
        />
        <sidebar-link
          to="/statistics"
          :name="$t('sidebar.Statistics')"
          icon="tim-icons icon-chart-pie-36"
        />
        <sidebar-link
          to="/pitfalls"
          :name="$t('sidebar.Pitfalls')"
          icon="tim-icons icon-light-3"
        />
      </template>
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>

      <dashboard-content @click.native="toggleSidebar"> </dashboard-content>

      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss">
</style>
<script>
import TopNavbar from "./TopNavbar.vue";
import ContentFooter from "./ContentFooter.vue";
import DashboardContent from "./Content.vue";
import MobileMenu from "./MobileMenu";
export default {
  components: {
    TopNavbar,
    ContentFooter,
    DashboardContent,
    MobileMenu,
  }, 
  methods: {
    toggleSidebar() {
      if (this.$sidebar.showSidebar) {
        this.$sidebar.displaySidebar(false);
      }
    },
  },
};
</script>
