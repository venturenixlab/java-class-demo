import { createApp } from "vue";
import App from "./components/App.vue";
import "./components/assets/tailwind.css";
// fontawesome
import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faCaretUp,
  faCaretDown,
  faSearch,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
library.add(faCaretUp, faCaretDown, faSearch);

const app = createApp(App);
app.component("fa", FontAwesomeIcon);
app.mount("#app");

// custom filter
app.config.globalProperties.$filters = {
  // percent
  price_negative(value) {
    if (value.toString().includes("-")) {
      return value;
    }
    return "";
  },
  // comma
  comma_separator(value) {
    // Add comma for dollar format, i.e. 1,000,000
    return value.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
  },
  // truncate string
  string_trunc(value, size) {
    if (!value) return "";
    value = value.toString();
    if (value.length <= size) {
      return value;
    }
    return value.substr(0, size);
  },
}
