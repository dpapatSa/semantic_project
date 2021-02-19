import { Pie, mixins } from 'vue-chartjs';

export default {
  name: 'pie-chart',
  extends: Pie,
  mixins: [mixins.reactiveProp],
  props: {
    extraOptions: Object, 
  },
  data() {
    return {
      ctx: null
    };
  },
  methods: {
    updateGradients(chartData) {
      if (!chartData) return;
      const ctx = this.ctx || document.getElementById(this.chartId).getContext('2d');
     
      chartData.datasets.forEach(set => {
        set.backgroundColor = gradientStroke;
      });
    }
  },
  mounted() {
    this.$watch('chartData', (newVal, oldVal) => { 
      if (!oldVal) {
        this.renderChart(
          this.chartData,
          this.extraOptions
        );
      }
    }, { immediate: true });
  }
};
