<template>
  <div>
    <div class="row" v-if="!show">
      <card type="chart"> <h4>Please Wait Loading...</h4></card>
    </div>
    <div class="row" v-if="show">
      <div class="col-lg-12">
        <card type="chart" style="color: lightgrey">
          <ul>
            In the pie charts below you can see the number of pitfall cases for
            each ontology, in slices.
            <br />
            Specifically:
            <br />
            - Missing Annotations
            <br />
            - Unconnected Ontologies
          </ul>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Musicontology</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="purple-bar-chart"
              :extra-options="barChart.extraOptions"
              :chart-data="barChart.musicontology_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Friend of a friend (FOAF)</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.foaf_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Dublincore</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.dublincore_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Cidoc</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.cidoc_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Pizza</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.pizza_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
    </div>
  </div>
</template>



<script>
import LineChart from "@/components/Charts/LineChart";
import BarChart from "@/components/Charts/BarChart"; 
import Card from "@/components/Cards/Card";

import * as chartConfigs from "@/components/Charts/config";
import config from "@/config";
import axios from "axios";

let musicontology_data = [];
let foaf_data = [];
let cidoc_data = [];
let dublincore_data = [];
let pizza_data = [];

export default {
  components: {
    LineChart,
    BarChart, 
    Card,
  },
  data() {
    return {
      show: false,
      barChart: {
        type: "pie",
        musicontology_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Musicontology",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: musicontology_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        foaf_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Foaf",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: foaf_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        cidoc_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Cidoc",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: cidoc_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        dublincore_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Dublincore",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: dublincore_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        pizza_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Pizza",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: pizza_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
      },
    };
  },
  created() {
    this.show = false;
    axios
      .get(
        "http://localhost:9090/Project_Final/webresources/musicontology/pitfalls"
      )
      .then((result) => {
        musicontology_data.push(result.data.MissingAnnotations);
        musicontology_data.push(result.data.UnconnectedOntology);
        axios
          .get("http://localhost:9090/Project_Final/webresources/foaf/pitfalls")
          .then((result) => {
            foaf_data.push(result.data.MissingAnnotations);
            foaf_data.push(result.data.UnconnectedOntology);
            axios
              .get(
                "http://localhost:9090/Project_Final/webresources/cidoc/pitfalls"
              )
              .then((result) => {
                cidoc_data.push(result.data.MissingAnnotations);
                cidoc_data.push(result.data.UnconnectedOntology);
                axios
                  .get(
                    "http://localhost:9090/Project_Final/webresources/dublincore/pitfalls"
                  )
                  .then((result) => {
                    dublincore_data.push(result.data.MissingAnnotations);
                    dublincore_data.push(result.data.UnconnectedOntology);

                    axios
                      .get(
                        "http://localhost:9090/Project_Final/webresources/pizza/pitfalls"
                      )
                      .then((result) => {
                        pizza_data.push(result.data.MissingAnnotations);
                        pizza_data.push(result.data.UnconnectedOntology);
                        this.show = true;
                      });
                  });
              });
          });
      });
  },
};
</script>

<style>
</style>
