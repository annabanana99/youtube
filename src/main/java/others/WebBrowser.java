package others;

public enum WebBrowser {

        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge");

        private String name;

        WebBrowser(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


