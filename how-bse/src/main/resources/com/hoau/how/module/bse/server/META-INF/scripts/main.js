(function() {
    var a = this,
    b = a._,
    c = {},
    d = Array.prototype,
    e = Object.prototype,
    f = Function.prototype,
    g = d.push,
    h = d.slice,
    i = d.concat,
    j = e.toString,
    k = e.hasOwnProperty,
    l = d.forEach,
    m = d.map,
    n = d.reduce,
    o = d.reduceRight,
    p = d.filter,
    q = d.every,
    r = d.some,
    s = d.indexOf,
    t = d.lastIndexOf,
    u = Array.isArray,
    v = Object.keys,
    w = f.bind,
    x = function(a) {
        return a instanceof x ? a: this instanceof x ? void(this._wrapped = a) : new x(a)
    };
    "undefined" != typeof exports ? ("undefined" != typeof module && module.exports && (exports = module.exports = x), exports._ = x) : a._ = x,
    x.VERSION = "1.4.4";
    var y = x.each = x.forEach = function(a, b, d) {
        if (null != a) if (l && a.forEach === l) a.forEach(b, d);
        else if (a.length === +a.length) {
            for (var e = 0,
            f = a.length; f > e; e++) if (b.call(d, a[e], e, a) === c) return
        } else for (var g in a) if (x.has(a, g) && b.call(d, a[g], g, a) === c) return
    };
    x.map = x.collect = function(a, b, c) {
        var d = [];
        return null == a ? d: m && a.map === m ? a.map(b, c) : (y(a,
        function(a, e, f) {
            d[d.length] = b.call(c, a, e, f)
        }), d)
    };
    var z = "Reduce of empty array with no initial value";
    x.reduce = x.foldl = x.inject = function(a, b, c, d) {
        var e = arguments.length > 2;
        if (null == a && (a = []), n && a.reduce === n) return d && (b = x.bind(b, d)),
        e ? a.reduce(b, c) : a.reduce(b);
        if (y(a,
        function(a, f, g) {
            e ? c = b.call(d, c, a, f, g) : (c = a, e = !0)
        }), !e) throw new TypeError(z);
        return c
    },
    x.reduceRight = x.foldr = function(a, b, c, d) {
        var e = arguments.length > 2;
        if (null == a && (a = []), o && a.reduceRight === o) return d && (b = x.bind(b, d)),
        e ? a.reduceRight(b, c) : a.reduceRight(b);
        var f = a.length;
        if (f !== +f) {
            var g = x.keys(a);
            f = g.length
        }
        if (y(a,
        function(h, i, j) {
            i = g ? g[--f] : --f,
            e ? c = b.call(d, c, a[i], i, j) : (c = a[i], e = !0)
        }), !e) throw new TypeError(z);
        return c
    },
    x.find = x.detect = function(a, b, c) {
        var d;
        return A(a,
        function(a, e, f) {
            return b.call(c, a, e, f) ? (d = a, !0) : void 0
        }),
        d
    },
    x.filter = x.select = function(a, b, c) {
        var d = [];
        return null == a ? d: p && a.filter === p ? a.filter(b, c) : (y(a,
        function(a, e, f) {
            b.call(c, a, e, f) && (d[d.length] = a)
        }), d)
    },
    x.reject = function(a, b, c) {
        return x.filter(a,
        function(a, d, e) {
            return ! b.call(c, a, d, e)
        },
        c)
    },
    x.every = x.all = function(a, b, d) {
        b || (b = x.identity);
        var e = !0;
        return null == a ? e: q && a.every === q ? a.every(b, d) : (y(a,
        function(a, f, g) {
            return (e = e && b.call(d, a, f, g)) ? void 0 : c
        }), !!e)
    };
    var A = x.some = x.any = function(a, b, d) {
        b || (b = x.identity);
        var e = !1;
        return null == a ? e: r && a.some === r ? a.some(b, d) : (y(a,
        function(a, f, g) {
            return e || (e = b.call(d, a, f, g)) ? c: void 0
        }), !!e)
    };
    x.contains = x.include = function(a, b) {
        return null == a ? !1 : s && a.indexOf === s ? -1 != a.indexOf(b) : A(a,
        function(a) {
            return a === b
        })
    },
    x.invoke = function(a, b) {
        var c = h.call(arguments, 2),
        d = x.isFunction(b);
        return x.map(a,
        function(a) {
            return (d ? b: a[b]).apply(a, c)
        })
    },
    x.pluck = function(a, b) {
        return x.map(a,
        function(a) {
            return a[b]
        })
    },
    x.where = function(a, b, c) {
        return x.isEmpty(b) ? c ? null: [] : x[c ? "find": "filter"](a,
        function(a) {
            for (var c in b) if (b[c] !== a[c]) return ! 1;
            return ! 0
        })
    },
    x.findWhere = function(a, b) {
        return x.where(a, b, !0)
    },
    x.max = function(a, b, c) {
        if (!b && x.isArray(a) && a[0] === +a[0] && a.length < 65535) return Math.max.apply(Math, a);
        if (!b && x.isEmpty(a)) return - 1 / 0;
        var d = {
            computed: -1 / 0,
            value: -1 / 0
        };
        return y(a,
        function(a, e, f) {
            var g = b ? b.call(c, a, e, f) : a;
            g >= d.computed && (d = {
                value: a,
                computed: g
            })
        }),
        d.value
    },
    x.min = function(a, b, c) {
        if (!b && x.isArray(a) && a[0] === +a[0] && a.length < 65535) return Math.min.apply(Math, a);
        if (!b && x.isEmpty(a)) return 1 / 0;
        var d = {
            computed: 1 / 0,
            value: 1 / 0
        };
        return y(a,
        function(a, e, f) {
            var g = b ? b.call(c, a, e, f) : a;
            g < d.computed && (d = {
                value: a,
                computed: g
            })
        }),
        d.value
    },
    x.shuffle = function(a) {
        var b, c = 0,
        d = [];
        return y(a,
        function(a) {
            b = x.random(c++),
            d[c - 1] = d[b],
            d[b] = a
        }),
        d
    };
    var B = function(a) {
        return x.isFunction(a) ? a: function(b) {
            return b[a]
        }
    };
    x.sortBy = function(a, b, c) {
        var d = B(b);
        return x.pluck(x.map(a,
        function(a, b, e) {
            return {
                value: a,
                index: b,
                criteria: d.call(c, a, b, e)
            }
        }).sort(function(a, b) {
            var c = a.criteria,
            d = b.criteria;
            if (c !== d) {
                if (c > d || void 0 === c) return 1;
                if (d > c || void 0 === d) return - 1
            }
            return a.index < b.index ? -1 : 1
        }), "value")
    };
    var C = function(a, b, c, d) {
        var e = {},
        f = B(b || x.identity);
        return y(a,
        function(b, g) {
            var h = f.call(c, b, g, a);
            d(e, h, b)
        }),
        e
    };
    x.groupBy = function(a, b, c) {
        return C(a, b, c,
        function(a, b, c) { (x.has(a, b) ? a[b] : a[b] = []).push(c)
        })
    },
    x.countBy = function(a, b, c) {
        return C(a, b, c,
        function(a, b) {
            x.has(a, b) || (a[b] = 0),
            a[b]++
        })
    },
    x.sortedIndex = function(a, b, c, d) {
        c = null == c ? x.identity: B(c);
        for (var e = c.call(d, b), f = 0, g = a.length; g > f;) {
            var h = f + g >>> 1;
            c.call(d, a[h]) < e ? f = h + 1 : g = h
        }
        return f
    },
    x.toArray = function(a) {
        return a ? x.isArray(a) ? h.call(a) : a.length === +a.length ? x.map(a, x.identity) : x.values(a) : []
    },
    x.size = function(a) {
        return null == a ? 0 : a.length === +a.length ? a.length: x.keys(a).length
    },
    x.first = x.head = x.take = function(a, b, c) {
        return null == a ? void 0 : null == b || c ? a[0] : h.call(a, 0, b)
    },
    x.initial = function(a, b, c) {
        return h.call(a, 0, a.length - (null == b || c ? 1 : b))
    },
    x.last = function(a, b, c) {
        return null == a ? void 0 : null == b || c ? a[a.length - 1] : h.call(a, Math.max(a.length - b, 0))
    },
    x.rest = x.tail = x.drop = function(a, b, c) {
        return h.call(a, null == b || c ? 1 : b)
    },
    x.compact = function(a) {
        return x.filter(a, x.identity)
    };
    var D = function(a, b, c) {
        return y(a,
        function(a) {
            x.isArray(a) ? b ? g.apply(c, a) : D(a, b, c) : c.push(a)
        }),
        c
    };
    x.flatten = function(a, b) {
        return D(a, b, [])
    },
    x.without = function(a) {
        return x.difference(a, h.call(arguments, 1))
    },
    x.uniq = x.unique = function(a, b, c, d) {
        x.isFunction(b) && (d = c, c = b, b = !1);
        var e = c ? x.map(a, c, d) : a,
        f = [],
        g = [];
        return y(e,
        function(c, d) { (b ? d && g[g.length - 1] === c: x.contains(g, c)) || (g.push(c), f.push(a[d]))
        }),
        f
    },
    x.union = function() {
        return x.uniq(i.apply(d, arguments))
    },
    x.intersection = function(a) {
        var b = h.call(arguments, 1);
        return x.filter(x.uniq(a),
        function(a) {
            return x.every(b,
            function(b) {
                return x.indexOf(b, a) >= 0
            })
        })
    },
    x.difference = function(a) {
        var b = i.apply(d, h.call(arguments, 1));
        return x.filter(a,
        function(a) {
            return ! x.contains(b, a)
        })
    },
    x.zip = function() {
        for (var a = h.call(arguments), b = x.max(x.pluck(a, "length")), c = new Array(b), d = 0; b > d; d++) c[d] = x.pluck(a, "" + d);
        return c
    },
    x.object = function(a, b) {
        if (null == a) return {};
        for (var c = {},
        d = 0,
        e = a.length; e > d; d++) b ? c[a[d]] = b[d] : c[a[d][0]] = a[d][1];
        return c
    },
    x.indexOf = function(a, b, c) {
        if (null == a) return - 1;
        var d = 0,
        e = a.length;
        if (c) {
            if ("number" != typeof c) return d = x.sortedIndex(a, b),
            a[d] === b ? d: -1;
            d = 0 > c ? Math.max(0, e + c) : c
        }
        if (s && a.indexOf === s) return a.indexOf(b, c);
        for (; e > d; d++) if (a[d] === b) return d;
        return - 1
    },
    x.lastIndexOf = function(a, b, c) {
        if (null == a) return - 1;
        var d = null != c;
        if (t && a.lastIndexOf === t) return d ? a.lastIndexOf(b, c) : a.lastIndexOf(b);
        for (var e = d ? c: a.length; e--;) if (a[e] === b) return e;
        return - 1
    },
    x.range = function(a, b, c) {
        arguments.length <= 1 && (b = a || 0, a = 0),
        c = arguments[2] || 1;
        for (var d = Math.max(Math.ceil((b - a) / c), 0), e = 0, f = new Array(d); d > e;) f[e++] = a,
        a += c;
        return f
    },
    x.bind = function(a, b) {
        if (a.bind === w && w) return w.apply(a, h.call(arguments, 1));
        var c = h.call(arguments, 2);
        return function() {
            return a.apply(b, c.concat(h.call(arguments)))
        }
    },
    x.partial = function(a) {
        var b = h.call(arguments, 1);
        return function() {
            return a.apply(this, b.concat(h.call(arguments)))
        }
    },
    x.bindAll = function(a) {
        var b = h.call(arguments, 1);
        return 0 === b.length && (b = x.functions(a)),
        y(b,
        function(b) {
            a[b] = x.bind(a[b], a)
        }),
        a
    },
    x.memoize = function(a, b) {
        var c = {};
        return b || (b = x.identity),
        function() {
            var d = b.apply(this, arguments);
            return x.has(c, d) ? c[d] : c[d] = a.apply(this, arguments)
        }
    },
    x.delay = function(a, b) {
        var c = h.call(arguments, 2);
        return setTimeout(function() {
            return a.apply(null, c)
        },
        b)
    },
    x.defer = function(a) {
        return x.delay.apply(x, [a, 1].concat(h.call(arguments, 1)))
    },
    x.throttle = function(a, b) {
        var c, d, e, f, g = 0,
        h = function() {
            g = new Date,
            e = null,
            f = a.apply(c, d)
        };
        return function() {
            var i = new Date,
            j = b - (i - g);
            return c = this,
            d = arguments,
            0 >= j ? (clearTimeout(e), e = null, g = i, f = a.apply(c, d)) : e || (e = setTimeout(h, j)),
            f
        }
    },
    x.debounce = function(a, b, c) {
        var d, e;
        return function() {
            var f = this,
            g = arguments,
            h = function() {
                d = null,
                c || (e = a.apply(f, g))
            },
            i = c && !d;
            return clearTimeout(d),
            d = setTimeout(h, b),
            i && (e = a.apply(f, g)),
            e
        }
    },
    x.once = function(a) {
        var b, c = !1;
        return function() {
            return c ? b: (c = !0, b = a.apply(this, arguments), a = null, b)
        }
    },
    x.wrap = function(a, b) {
        return function() {
            var c = [a];
            return g.apply(c, arguments),
            b.apply(this, c)
        }
    },
    x.compose = function() {
        var a = arguments;
        return function() {
            for (var b = arguments,
            c = a.length - 1; c >= 0; c--) b = [a[c].apply(this, b)];
            return b[0]
        }
    },
    x.after = function(a, b) {
        return 0 >= a ? b() : function() {
            return--a < 1 ? b.apply(this, arguments) : void 0
        }
    },
    x.keys = v ||
    function(a) {
        if (a !== Object(a)) throw new TypeError("Invalid object");
        var b = [];
        for (var c in a) x.has(a, c) && (b[b.length] = c);
        return b
    },
    x.values = function(a) {
        var b = [];
        for (var c in a) x.has(a, c) && b.push(a[c]);
        return b
    },
    x.pairs = function(a) {
        var b = [];
        for (var c in a) x.has(a, c) && b.push([c, a[c]]);
        return b
    },
    x.invert = function(a) {
        var b = {};
        for (var c in a) x.has(a, c) && (b[a[c]] = c);
        return b
    },
    x.functions = x.methods = function(a) {
        var b = [];
        for (var c in a) x.isFunction(a[c]) && b.push(c);
        return b.sort()
    },
    x.extend = function(a) {
        return y(h.call(arguments, 1),
        function(b) {
            if (b) for (var c in b) a[c] = b[c]
        }),
        a
    },
    x.pick = function(a) {
        var b = {},
        c = i.apply(d, h.call(arguments, 1));
        return y(c,
        function(c) {
            c in a && (b[c] = a[c])
        }),
        b
    },
    x.omit = function(a) {
        var b = {},
        c = i.apply(d, h.call(arguments, 1));
        for (var e in a) x.contains(c, e) || (b[e] = a[e]);
        return b
    },
    x.defaults = function(a) {
        return y(h.call(arguments, 1),
        function(b) {
            if (b) for (var c in b) null == a[c] && (a[c] = b[c])
        }),
        a
    },
    x.clone = function(a) {
        return x.isObject(a) ? x.isArray(a) ? a.slice() : x.extend({},
        a) : a
    },
    x.tap = function(a, b) {
        return b(a),
        a
    };
    var E = function(a, b, c, d) {
        if (a === b) return 0 !== a || 1 / a == 1 / b;
        if (null == a || null == b) return a === b;
        a instanceof x && (a = a._wrapped),
        b instanceof x && (b = b._wrapped);
        var e = j.call(a);
        if (e != j.call(b)) return ! 1;
        switch (e) {
        case "[object String]":
            return a == String(b);
        case "[object Number]":
            return a != +a ? b != +b: 0 == a ? 1 / a == 1 / b: a == +b;
        case "[object Date]":
        case "[object Boolean]":
            return + a == +b;
        case "[object RegExp]":
            return a.source == b.source && a.global == b.global && a.multiline == b.multiline && a.ignoreCase == b.ignoreCase
        }
        if ("object" != typeof a || "object" != typeof b) return ! 1;
        for (var f = c.length; f--;) if (c[f] == a) return d[f] == b;
        c.push(a),
        d.push(b);
        var g = 0,
        h = !0;
        if ("[object Array]" == e) {
            if (g = a.length, h = g == b.length) for (; g--&&(h = E(a[g], b[g], c, d)););
        } else {
            var i = a.constructor,
            k = b.constructor;
            if (i !== k && !(x.isFunction(i) && i instanceof i && x.isFunction(k) && k instanceof k)) return ! 1;
            for (var l in a) if (x.has(a, l) && (g++, !(h = x.has(b, l) && E(a[l], b[l], c, d)))) break;
            if (h) {
                for (l in b) if (x.has(b, l) && !g--) break;
                h = !g
            }
        }
        return c.pop(),
        d.pop(),
        h
    };
    x.isEqual = function(a, b) {
        return E(a, b, [], [])
    },
    x.isEmpty = function(a) {
        if (null == a) return ! 0;
        if (x.isArray(a) || x.isString(a)) return 0 === a.length;
        for (var b in a) if (x.has(a, b)) return ! 1;
        return ! 0
    },
    x.isElement = function(a) {
        return ! (!a || 1 !== a.nodeType)
    },
    x.isArray = u ||
    function(a) {
        return "[object Array]" == j.call(a)
    },
    x.isObject = function(a) {
        return a === Object(a)
    },
    y(["Arguments", "Function", "String", "Number", "Date", "RegExp"],
    function(a) {
        x["is" + a] = function(b) {
            return j.call(b) == "[object " + a + "]"
        }
    }),
    x.isArguments(arguments) || (x.isArguments = function(a) {
        return ! (!a || !x.has(a, "callee"))
    }),
    "function" != typeof / . / &&(x.isFunction = function(a) {
        return "function" == typeof a
    }),
    x.isFinite = function(a) {
        return isFinite(a) && !isNaN(parseFloat(a))
    },
    x.isNaN = function(a) {
        return x.isNumber(a) && a != +a
    },
    x.isBoolean = function(a) {
        return a === !0 || a === !1 || "[object Boolean]" == j.call(a)
    },
    x.isNull = function(a) {
        return null === a
    },
    x.isUndefined = function(a) {
        return void 0 === a
    },
    x.has = function(a, b) {
        return k.call(a, b)
    },
    x.noConflict = function() {
        return a._ = b,
        this
    },
    x.identity = function(a) {
        return a
    },
    x.times = function(a, b, c) {
        for (var d = Array(a), e = 0; a > e; e++) d[e] = b.call(c, e);
        return d
    },
    x.random = function(a, b) {
        return null == b && (b = a, a = 0),
        a + Math.floor(Math.random() * (b - a + 1))
    };
    var F = {
        escape: {
            "&": "&amp;",
            "<": "&lt;",
            ">": "&gt;",
            '"': "&quot;",
            "'": "&#x27;",
            "/": "&#x2F;"
        }
    };
    F.unescape = x.invert(F.escape);
    var G = {
        escape: new RegExp("[" + x.keys(F.escape).join("") + "]", "g"),
        unescape: new RegExp("(" + x.keys(F.unescape).join("|") + ")", "g")
    };
    x.each(["escape", "unescape"],
    function(a) {
        x[a] = function(b) {
            return null == b ? "": ("" + b).replace(G[a],
            function(b) {
                return F[a][b]
            })
        }
    }),
    x.result = function(a, b) {
        if (null == a) return null;
        var c = a[b];
        return x.isFunction(c) ? c.call(a) : c
    },
    x.mixin = function(a) {
        y(x.functions(a),
        function(b) {
            var c = x[b] = a[b];
            x.prototype[b] = function() {
                var a = [this._wrapped];
                return g.apply(a, arguments),
                L.call(this, c.apply(x, a))
            }
        })
    };
    var H = 0;
    x.uniqueId = function(a) {
        var b = ++H + "";
        return a ? a + b: b
    },
    x.templateSettings = {
        evaluate: /<%([\s\S]+?)%>/g,
        interpolate: /<%=([\s\S]+?)%>/g,
        escape: /<%-([\s\S]+?)%>/g
    };
    var I = /(.)^/,
    J = {
        "'": "'",
        "\\": "\\",
        "\r": "r",
        "\n": "n",
        "	": "t",
        "\u2028": "u2028",
        "\u2029": "u2029"
    },
    K = /\\|'|\r|\n|\t|\u2028|\u2029/g;
    x.template = function(a, b, c) {
        var d;
        c = x.defaults({},
        c, x.templateSettings);
        var e = new RegExp([(c.escape || I).source, (c.interpolate || I).source, (c.evaluate || I).source].join("|") + "|$", "g"),
        f = 0,
        g = "__p+='";
        a.replace(e,
        function(b, c, d, e, h) {
            return g += a.slice(f, h).replace(K,
            function(a) {
                return "\\" + J[a]
            }),
            c && (g += "'+\n((__t=(" + c + "))==null?'':_.escape(__t))+\n'"),
            d && (g += "'+\n((__t=(" + d + "))==null?'':__t)+\n'"),
            e && (g += "';\n" + e + "\n__p+='"),
            f = h + b.length,
            b
        }),
        g += "';\n",
        c.variable || (g = "with(obj||{}){\n" + g + "}\n"),
        g = "var __t,__p='',__j=Array.prototype.join,print=function(){__p+=__j.call(arguments,'');};\n" + g + "return __p;\n";
        try {
            d = new Function(c.variable || "obj", "_", g)
        } catch(h) {
            throw h.source = g,
            h
        }
        if (b) return d(b, x);
        var i = function(a) {
            return d.call(this, a, x)
        };
        return i.source = "function(" + (c.variable || "obj") + "){\n" + g + "}",
        i
    },
    x.chain = function(a) {
        return x(a).chain()
    };
    var L = function(a) {
        return this._chain ? x(a).chain() : a
    };
    x.mixin(x),
    y(["pop", "push", "reverse", "shift", "sort", "splice", "unshift"],
    function(a) {
        var b = d[a];
        x.prototype[a] = function() {
            var c = this._wrapped;
            return b.apply(c, arguments),
            "shift" != a && "splice" != a || 0 !== c.length || delete c[0],
            L.call(this, c)
        }
    }),
    y(["concat", "join", "slice"],
    function(a) {
        var b = d[a];
        x.prototype[a] = function() {
            return L.call(this, b.apply(this._wrapped, arguments))
        }
    }),
    x.extend(x.prototype, {
        chain: function() {
            return this._chain = !0,
            this
        },
        value: function() {
            return this._wrapped
        }
    })
}).call(this),
define("underscore",
function(a) {
    return function() {
        var b;
        return b || a._
    }
} (this)),
function(a, b) {
    function c(a) {
        var b = a.length,
        c = ib.type(a);
        return ib.isWindow(a) ? !1 : 1 === a.nodeType && b ? !0 : "array" === c || "function" !== c && (0 === b || "number" == typeof b && b > 0 && b - 1 in a)
    }
    function d(a) {
        var b = xb[a] = {};
        return ib.each(a.match(kb) || [],
        function(a, c) {
            b[c] = !0
        }),
        b
    }
    function e(a, c, d, e) {
        if (ib.acceptData(a)) {
            var f, g, h = ib.expando,
            i = "string" == typeof c,
            j = a.nodeType,
            k = j ? ib.cache: a,
            l = j ? a[h] : a[h] && h;
            if (l && k[l] && (e || k[l].data) || !i || d !== b) return l || (j ? a[h] = l = _.pop() || ib.guid++:l = h),
            k[l] || (k[l] = {},
            j || (k[l].toJSON = ib.noop)),
            ("object" == typeof c || "function" == typeof c) && (e ? k[l] = ib.extend(k[l], c) : k[l].data = ib.extend(k[l].data, c)),
            f = k[l],
            e || (f.data || (f.data = {}), f = f.data),
            d !== b && (f[ib.camelCase(c)] = d),
            i ? (g = f[c], null == g && (g = f[ib.camelCase(c)])) : g = f,
            g
        }
    }
    function f(a, b, c) {
        if (ib.acceptData(a)) {
            var d, e, f, g = a.nodeType,
            i = g ? ib.cache: a,
            j = g ? a[ib.expando] : ib.expando;
            if (i[j]) {
                if (b && (f = c ? i[j] : i[j].data)) {
                    ib.isArray(b) ? b = b.concat(ib.map(b, ib.camelCase)) : b in f ? b = [b] : (b = ib.camelCase(b), b = b in f ? [b] : b.split(" "));
                    for (d = 0, e = b.length; e > d; d++) delete f[b[d]];
                    if (! (c ? h: ib.isEmptyObject)(f)) return
                } (c || (delete i[j].data, h(i[j]))) && (g ? ib.cleanData([a], !0) : ib.support.deleteExpando || i != i.window ? delete i[j] : i[j] = null)
            }
        }
    }
    function g(a, c, d) {
        if (d === b && 1 === a.nodeType) {
            var e = "data-" + c.replace(zb, "-$1").toLowerCase();
            if (d = a.getAttribute(e), "string" == typeof d) {
                try {
                    d = "true" === d ? !0 : "false" === d ? !1 : "null" === d ? null: +d + "" === d ? +d: yb.test(d) ? ib.parseJSON(d) : d
                } catch(f) {}
                ib.data(a, c, d)
            } else d = b
        }
        return d
    }
    function h(a) {
        var b;
        for (b in a) if (("data" !== b || !ib.isEmptyObject(a[b])) && "toJSON" !== b) return ! 1;
        return ! 0
    }
    function i() {
        return ! 0
    }
    function j() {
        return ! 1
    }
    function k(a, b) {
        do a = a[b];
        while (a && 1 !== a.nodeType);
        return a
    }
    function l(a, b, c) {
        if (b = b || 0, ib.isFunction(b)) return ib.grep(a,
        function(a, d) {
            var e = !!b.call(a, d, a);
            return e === c
        });
        if (b.nodeType) return ib.grep(a,
        function(a) {
            return a === b === c
        });
        if ("string" == typeof b) {
            var d = ib.grep(a,
            function(a) {
                return 1 === a.nodeType
            });
            if (Rb.test(b)) return ib.filter(b, d, !c);
            b = ib.filter(b, d)
        }
        return ib.grep(a,
        function(a) {
            return ib.inArray(a, b) >= 0 === c
        })
    }
    function m(a) {
        var b = Ub.split("|"),
        c = a.createDocumentFragment();
        if (c.createElement) for (; b.length;) c.createElement(b.pop());
        return c
    }
    function n(a, b) {
        return a.getElementsByTagName(b)[0] || a.appendChild(a.ownerDocument.createElement(b))
    }
    function o(a) {
        var b = a.getAttributeNode("type");
        return a.type = (b && b.specified) + "/" + a.type,
        a
    }
    function p(a) {
        var b = ec.exec(a.type);
        return b ? a.type = b[1] : a.removeAttribute("type"),
        a
    }
    function q(a, b) {
        for (var c, d = 0; null != (c = a[d]); d++) ib._data(c, "globalEval", !b || ib._data(b[d], "globalEval"))
    }
    function r(a, b) {
        if (1 === b.nodeType && ib.hasData(a)) {
            var c, d, e, f = ib._data(a),
            g = ib._data(b, f),
            h = f.events;
            if (h) {
                delete g.handle,
                g.events = {};
                for (c in h) for (d = 0, e = h[c].length; e > d; d++) ib.event.add(b, c, h[c][d])
            }
            g.data && (g.data = ib.extend({},
            g.data))
        }
    }
    function s(a, b) {
        var c, d, e;
        if (1 === b.nodeType) {
            if (c = b.nodeName.toLowerCase(), !ib.support.noCloneEvent && b[ib.expando]) {
                e = ib._data(b);
                for (d in e.events) ib.removeEvent(b, d, e.handle);
                b.removeAttribute(ib.expando)
            }
            "script" === c && b.text !== a.text ? (o(b).text = a.text, p(b)) : "object" === c ? (b.parentNode && (b.outerHTML = a.outerHTML), ib.support.html5Clone && a.innerHTML && !ib.trim(b.innerHTML) && (b.innerHTML = a.innerHTML)) : "input" === c && bc.test(a.type) ? (b.defaultChecked = b.checked = a.checked, b.value !== a.value && (b.value = a.value)) : "option" === c ? b.defaultSelected = b.selected = a.defaultSelected: ("input" === c || "textarea" === c) && (b.defaultValue = a.defaultValue)
        }
    }
    function t(a, c) {
        var d, e, f = 0,
        g = typeof a.getElementsByTagName !== V ? a.getElementsByTagName(c || "*") : typeof a.querySelectorAll !== V ? a.querySelectorAll(c || "*") : b;
        if (!g) for (g = [], d = a.childNodes || a; null != (e = d[f]); f++) ! c || ib.nodeName(e, c) ? g.push(e) : ib.merge(g, t(e, c));
        return c === b || c && ib.nodeName(a, c) ? ib.merge([a], g) : g
    }
    function u(a) {
        bc.test(a.type) && (a.defaultChecked = a.checked)
    }
    function v(a, b) {
        if (b in a) return b;
        for (var c = b.charAt(0).toUpperCase() + b.slice(1), d = b, e = yc.length; e--;) if (b = yc[e] + c, b in a) return b;
        return d
    }
    function w(a, b) {
        return a = b || a,
        "none" === ib.css(a, "display") || !ib.contains(a.ownerDocument, a)
    }
    function x(a, b) {
        for (var c, d, e, f = [], g = 0, h = a.length; h > g; g++) d = a[g],
        d.style && (f[g] = ib._data(d, "olddisplay"), c = d.style.display, b ? (f[g] || "none" !== c || (d.style.display = ""), "" === d.style.display && w(d) && (f[g] = ib._data(d, "olddisplay", B(d.nodeName)))) : f[g] || (e = w(d), (c && "none" !== c || !e) && ib._data(d, "olddisplay", e ? c: ib.css(d, "display"))));
        for (g = 0; h > g; g++) d = a[g],
        d.style && (b && "none" !== d.style.display && "" !== d.style.display || (d.style.display = b ? f[g] || "": "none"));
        return a
    }
    function y(a, b, c) {
        var d = rc.exec(b);
        return d ? Math.max(0, d[1] - (c || 0)) + (d[2] || "px") : b
    }
    function z(a, b, c, d, e) {
        for (var f = c === (d ? "border": "content") ? 4 : "width" === b ? 1 : 0, g = 0; 4 > f; f += 2)"margin" === c && (g += ib.css(a, c + xc[f], !0, e)),
        d ? ("content" === c && (g -= ib.css(a, "padding" + xc[f], !0, e)), "margin" !== c && (g -= ib.css(a, "border" + xc[f] + "Width", !0, e))) : (g += ib.css(a, "padding" + xc[f], !0, e), "padding" !== c && (g += ib.css(a, "border" + xc[f] + "Width", !0, e)));
        return g
    }
    function A(a, b, c) {
        var d = !0,
        e = "width" === b ? a.offsetWidth: a.offsetHeight,
        f = kc(a),
        g = ib.support.boxSizing && "border-box" === ib.css(a, "boxSizing", !1, f);
        if (0 >= e || null == e) {
            if (e = lc(a, b, f), (0 > e || null == e) && (e = a.style[b]), sc.test(e)) return e;
            d = g && (ib.support.boxSizingReliable || e === a.style[b]),
            e = parseFloat(e) || 0
        }
        return e + z(a, b, c || (g ? "border": "content"), d, f) + "px"
    }
    function B(a) {
        var b = W,
        c = uc[a];
        return c || (c = C(a, b), "none" !== c && c || (jc = (jc || ib("<iframe frameborder='0' width='0' height='0'/>").css("cssText", "display:block !important")).appendTo(b.documentElement), b = (jc[0].contentWindow || jc[0].contentDocument).document, b.write("<!doctype html><html><body>"), b.close(), c = C(a, b), jc.detach()), uc[a] = c),
        c
    }
    function C(a, b) {
        var c = ib(b.createElement(a)).appendTo(b.body),
        d = ib.css(c[0], "display");
        return c.remove(),
        d
    }
    function D(a, b, c, d) {
        var e;
        if (ib.isArray(b)) ib.each(b,
        function(b, e) {
            c || Ac.test(a) ? d(a, e) : D(a + "[" + ("object" == typeof e ? b: "") + "]", e, c, d)
        });
        else if (c || "object" !== ib.type(b)) d(a, b);
        else for (e in b) D(a + "[" + e + "]", b[e], c, d)
    }
    function E(a) {
        return function(b, c) {
            "string" != typeof b && (c = b, b = "*");
            var d, e = 0,
            f = b.toLowerCase().match(kb) || [];
            if (ib.isFunction(c)) for (; d = f[e++];)"+" === d[0] ? (d = d.slice(1) || "*", (a[d] = a[d] || []).unshift(c)) : (a[d] = a[d] || []).push(c)
        }
    }
    function F(a, b, c, d) {
        function e(h) {
            var i;
            return f[h] = !0,
            ib.each(a[h] || [],
            function(a, h) {
                var j = h(b, c, d);
                return "string" != typeof j || g || f[j] ? g ? !(i = j) : void 0 : (b.dataTypes.unshift(j), e(j), !1)
            }),
            i
        }
        var f = {},
        g = a === Rc;
        return e(b.dataTypes[0]) || !f["*"] && e("*")
    }
    function G(a, c) {
        var d, e, f = ib.ajaxSettings.flatOptions || {};
        for (e in c) c[e] !== b && ((f[e] ? a: d || (d = {}))[e] = c[e]);
        return d && ib.extend(!0, a, d),
        a
    }
    function H(a, c, d) {
        var e, f, g, h, i = a.contents,
        j = a.dataTypes,
        k = a.responseFields;
        for (h in k) h in d && (c[k[h]] = d[h]);
        for (;
        "*" === j[0];) j.shift(),
        f === b && (f = a.mimeType || c.getResponseHeader("Content-Type"));
        if (f) for (h in i) if (i[h] && i[h].test(f)) {
            j.unshift(h);
            break
        }
        if (j[0] in d) g = j[0];
        else {
            for (h in d) {
                if (!j[0] || a.converters[h + " " + j[0]]) {
                    g = h;
                    break
                }
                e || (e = h)
            }
            g = g || e
        }
        return g ? (g !== j[0] && j.unshift(g), d[g]) : void 0
    }
    function I(a, b) {
        var c, d, e, f, g = {},
        h = 0,
        i = a.dataTypes.slice(),
        j = i[0];
        if (a.dataFilter && (b = a.dataFilter(b, a.dataType)), i[1]) for (e in a.converters) g[e.toLowerCase()] = a.converters[e];
        for (; d = i[++h];) if ("*" !== d) {
            if ("*" !== j && j !== d) {
                if (e = g[j + " " + d] || g["* " + d], !e) for (c in g) if (f = c.split(" "), f[1] === d && (e = g[j + " " + f[0]] || g["* " + f[0]])) {
                    e === !0 ? e = g[c] : g[c] !== !0 && (d = f[0], i.splice(h--, 0, d));
                    break
                }
                if (e !== !0) if (e && a["throws"]) b = e(b);
                else try {
                    b = e(b)
                } catch(k) {
                    return {
                        state: "parsererror",
                        error: e ? k: "No conversion from " + j + " to " + d
                    }
                }
            }
            j = d
        }
        return {
            state: "success",
            data: b
        }
    }
    function J() {
        try {
            return new a.XMLHttpRequest
        } catch(b) {}
    }
    function K() {
        try {
            return new a.ActiveXObject("Microsoft.XMLHTTP")
        } catch(b) {}
    }
    function L() {
        return setTimeout(function() {
            $c = b
        }),
        $c = ib.now()
    }
    function M(a, b) {
        ib.each(b,
        function(b, c) {
            for (var d = (ed[b] || []).concat(ed["*"]), e = 0, f = d.length; f > e; e++) if (d[e].call(a, b, c)) return
        })
    }
    function N(a, b, c) {
        var d, e, f = 0,
        g = dd.length,
        h = ib.Deferred().always(function() {
            delete i.elem
        }),
        i = function() {
            if (e) return ! 1;
            for (var b = $c || L(), c = Math.max(0, j.startTime + j.duration - b), d = c / j.duration || 0, f = 1 - d, g = 0, i = j.tweens.length; i > g; g++) j.tweens[g].run(f);
            return h.notifyWith(a, [j, f, c]),
            1 > f && i ? c: (h.resolveWith(a, [j]), !1)
        },
        j = h.promise({
            elem: a,
            props: ib.extend({},
            b),
            opts: ib.extend(!0, {
                specialEasing: {}
            },
            c),
            originalProperties: b,
            originalOptions: c,
            startTime: $c || L(),
            duration: c.duration,
            tweens: [],
            createTween: function(b, c) {
                var d = ib.Tween(a, j.opts, b, c, j.opts.specialEasing[b] || j.opts.easing);
                return j.tweens.push(d),
                d
            },
            stop: function(b) {
                var c = 0,
                d = b ? j.tweens.length: 0;
                if (e) return this;
                for (e = !0; d > c; c++) j.tweens[c].run(1);
                return b ? h.resolveWith(a, [j, b]) : h.rejectWith(a, [j, b]),
                this
            }
        }),
        k = j.props;
        for (O(k, j.opts.specialEasing); g > f; f++) if (d = dd[f].call(j, a, k, j.opts)) return d;
        return M(j, k),
        ib.isFunction(j.opts.start) && j.opts.start.call(a, j),
        ib.fx.timer(ib.extend(i, {
            elem: a,
            anim: j,
            queue: j.opts.queue
        })),
        j.progress(j.opts.progress).done(j.opts.done, j.opts.complete).fail(j.opts.fail).always(j.opts.always)
    }
    function O(a, b) {
        var c, d, e, f, g;
        for (e in a) if (d = ib.camelCase(e), f = b[d], c = a[e], ib.isArray(c) && (f = c[1], c = a[e] = c[0]), e !== d && (a[d] = c, delete a[e]), g = ib.cssHooks[d], g && "expand" in g) {
            c = g.expand(c),
            delete a[d];
            for (e in c) e in a || (a[e] = c[e], b[e] = f)
        } else b[d] = f
    }
    function P(a, b, c) {
        var d, e, f, g, h, i, j, k, l, m = this,
        n = a.style,
        o = {},
        p = [],
        q = a.nodeType && w(a);
        c.queue || (k = ib._queueHooks(a, "fx"), null == k.unqueued && (k.unqueued = 0, l = k.empty.fire, k.empty.fire = function() {
            k.unqueued || l()
        }), k.unqueued++, m.always(function() {
            m.always(function() {
                k.unqueued--,
                ib.queue(a, "fx").length || k.empty.fire()
            })
        })),
        1 === a.nodeType && ("height" in b || "width" in b) && (c.overflow = [n.overflow, n.overflowX, n.overflowY], "inline" === ib.css(a, "display") && "none" === ib.css(a, "float") && (ib.support.inlineBlockNeedsLayout && "inline" !== B(a.nodeName) ? n.zoom = 1 : n.display = "inline-block")),
        c.overflow && (n.overflow = "hidden", ib.support.shrinkWrapBlocks || m.always(function() {
            n.overflow = c.overflow[0],
            n.overflowX = c.overflow[1],
            n.overflowY = c.overflow[2]
        }));
        for (e in b) if (g = b[e], ad.exec(g)) {
            if (delete b[e], i = i || "toggle" === g, g === (q ? "hide": "show")) continue;
            p.push(e)
        }
        if (f = p.length) {
            h = ib._data(a, "fxshow") || ib._data(a, "fxshow", {}),
            "hidden" in h && (q = h.hidden),
            i && (h.hidden = !q),
            q ? ib(a).show() : m.done(function() {
                ib(a).hide()
            }),
            m.done(function() {
                var b;
                ib._removeData(a, "fxshow");
                for (b in o) ib.style(a, b, o[b])
            });
            for (e = 0; f > e; e++) d = p[e],
            j = m.createTween(d, q ? h[d] : 0),
            o[d] = h[d] || ib.style(a, d),
            d in h || (h[d] = j.start, q && (j.end = j.start, j.start = "width" === d || "height" === d ? 1 : 0))
        }
    }
    function Q(a, b, c, d, e) {
        return new Q.prototype.init(a, b, c, d, e)
    }
    function R(a, b) {
        var c, d = {
            height: a
        },
        e = 0;
        for (b = b ? 1 : 0; 4 > e; e += 2 - b) c = xc[e],
        d["margin" + c] = d["padding" + c] = a;
        return b && (d.opacity = d.width = a),
        d
    }
    function S(a) {
        return ib.isWindow(a) ? a: 9 === a.nodeType ? a.defaultView || a.parentWindow: !1
    }
    var T, U, V = typeof b,
    W = a.document,
    X = a.location,
    Y = a.jQuery,
    Z = a.$,
    $ = {},
    _ = [],
    ab = "1.9.1",
    bb = _.concat,
    cb = _.push,
    db = _.slice,
    eb = _.indexOf,
    fb = $.toString,
    gb = $.hasOwnProperty,
    hb = ab.trim,
    ib = function(a, b) {
        return new ib.fn.init(a, b, U)
    },
    jb = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source,
    kb = /\S+/g,
    lb = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,
    mb = /^(?:(<[\w\W]+>)[^>]*|#([\w-]*))$/,
    nb = /^<(\w+)\s*\/?>(?:<\/\1>|)$/,
    ob = /^[\],:{}\s]*$/,
    pb = /(?:^|:|,)(?:\s*\[)+/g,
    qb = /\\(?:["\\\/bfnrt]|u[\da-fA-F]{4})/g,
    rb = /"[^"\\\r\n]*"|true|false|null|-?(?:\d+\.|)\d+(?:[eE][+-]?\d+|)/g,
    sb = /^-ms-/,
    tb = /-([\da-z])/gi,
    ub = function(a, b) {
        return b.toUpperCase()
    },
    vb = function(a) { (W.addEventListener || "load" === a.type || "complete" === W.readyState) && (wb(), ib.ready())
    },
    wb = function() {
        W.addEventListener ? (W.removeEventListener("DOMContentLoaded", vb, !1), a.removeEventListener("load", vb, !1)) : (W.detachEvent("onreadystatechange", vb), a.detachEvent("onload", vb))
    };
    ib.fn = ib.prototype = {
        jquery: ab,
        constructor: ib,
        init: function(a, c, d) {
            var e, f;
            if (!a) return this;
            if ("string" == typeof a) {
                if (e = "<" === a.charAt(0) && ">" === a.charAt(a.length - 1) && a.length >= 3 ? [null, a, null] : mb.exec(a), !e || !e[1] && c) return ! c || c.jquery ? (c || d).find(a) : this.constructor(c).find(a);
                if (e[1]) {
                    if (c = c instanceof ib ? c[0] : c, ib.merge(this, ib.parseHTML(e[1], c && c.nodeType ? c.ownerDocument || c: W, !0)), nb.test(e[1]) && ib.isPlainObject(c)) for (e in c) ib.isFunction(this[e]) ? this[e](c[e]) : this.attr(e, c[e]);
                    return this
                }
                if (f = W.getElementById(e[2]), f && f.parentNode) {
                    if (f.id !== e[2]) return d.find(a);
                    this.length = 1,
                    this[0] = f
                }
                return this.context = W,
                this.selector = a,
                this
            }
            return a.nodeType ? (this.context = this[0] = a, this.length = 1, this) : ib.isFunction(a) ? d.ready(a) : (a.selector !== b && (this.selector = a.selector, this.context = a.context), ib.makeArray(a, this))
        },
        selector: "",
        length: 0,
        size: function() {
            return this.length
        },
        toArray: function() {
            return db.call(this)
        },
        get: function(a) {
            return null == a ? this.toArray() : 0 > a ? this[this.length + a] : this[a]
        },
        pushStack: function(a) {
            var b = ib.merge(this.constructor(), a);
            return b.prevObject = this,
            b.context = this.context,
            b
        },
        each: function(a, b) {
            return ib.each(this, a, b)
        },
        ready: function(a) {
            return ib.ready.promise().done(a),
            this
        },
        slice: function() {
            return this.pushStack(db.apply(this, arguments))
        },
        first: function() {
            return this.eq(0)
        },
        last: function() {
            return this.eq( - 1)
        },
        eq: function(a) {
            var b = this.length,
            c = +a + (0 > a ? b: 0);
            return this.pushStack(c >= 0 && b > c ? [this[c]] : [])
        },
        map: function(a) {
            return this.pushStack(ib.map(this,
            function(b, c) {
                return a.call(b, c, b)
            }))
        },
        end: function() {
            return this.prevObject || this.constructor(null)
        },
        push: cb,
        sort: [].sort,
        splice: [].splice
    },
    ib.fn.init.prototype = ib.fn,
    ib.extend = ib.fn.extend = function() {
        var a, c, d, e, f, g, h = arguments[0] || {},
        i = 1,
        j = arguments.length,
        k = !1;
        for ("boolean" == typeof h && (k = h, h = arguments[1] || {},
        i = 2), "object" == typeof h || ib.isFunction(h) || (h = {}), j === i && (h = this, --i); j > i; i++) if (null != (f = arguments[i])) for (e in f) a = h[e],
        d = f[e],
        h !== d && (k && d && (ib.isPlainObject(d) || (c = ib.isArray(d))) ? (c ? (c = !1, g = a && ib.isArray(a) ? a: []) : g = a && ib.isPlainObject(a) ? a: {},
        h[e] = ib.extend(k, g, d)) : d !== b && (h[e] = d));
        return h
    },
    ib.extend({
        noConflict: function(b) {
            return a.$ === ib && (a.$ = Z),
            b && a.jQuery === ib && (a.jQuery = Y),
            ib
        },
        isReady: !1,
        readyWait: 1,
        holdReady: function(a) {
            a ? ib.readyWait++:ib.ready(!0)
        },
        ready: function(a) {
            if (a === !0 ? !--ib.readyWait: !ib.isReady) {
                if (!W.body) return setTimeout(ib.ready);
                ib.isReady = !0,
                a !== !0 && --ib.readyWait > 0 || (T.resolveWith(W, [ib]), ib.fn.trigger && ib(W).trigger("ready").off("ready"))
            }
        },
        isFunction: function(a) {
            return "function" === ib.type(a)
        },
        isArray: Array.isArray ||
        function(a) {
            return "array" === ib.type(a)
        },
        isWindow: function(a) {
            return null != a && a == a.window
        },
        isNumeric: function(a) {
            return ! isNaN(parseFloat(a)) && isFinite(a)
        },
        type: function(a) {
            return null == a ? String(a) : "object" == typeof a || "function" == typeof a ? $[fb.call(a)] || "object": typeof a
        },
        isPlainObject: function(a) {
            if (!a || "object" !== ib.type(a) || a.nodeType || ib.isWindow(a)) return ! 1;
            try {
                if (a.constructor && !gb.call(a, "constructor") && !gb.call(a.constructor.prototype, "isPrototypeOf")) return ! 1
            } catch(c) {
                return ! 1
            }
            var d;
            for (d in a);
            return d === b || gb.call(a, d)
        },
        isEmptyObject: function(a) {
            var b;
            for (b in a) return ! 1;
            return ! 0
        },
        error: function(a) {
            throw new Error(a)
        },
        parseHTML: function(a, b, c) {
            if (!a || "string" != typeof a) return null;
            "boolean" == typeof b && (c = b, b = !1),
            b = b || W;
            var d = nb.exec(a),
            e = !c && [];
            return d ? [b.createElement(d[1])] : (d = ib.buildFragment([a], b, e), e && ib(e).remove(), ib.merge([], d.childNodes))
        },
        parseJSON: function(b) {
            return a.JSON && a.JSON.parse ? a.JSON.parse(b) : null === b ? b: "string" == typeof b && (b = ib.trim(b), b && ob.test(b.replace(qb, "@").replace(rb, "]").replace(pb, ""))) ? new Function("return " + b)() : void ib.error("Invalid JSON: " + b)
        },
        parseXML: function(c) {
            var d, e;
            if (!c || "string" != typeof c) return null;
            try {
                a.DOMParser ? (e = new DOMParser, d = e.parseFromString(c, "text/xml")) : (d = new ActiveXObject("Microsoft.XMLDOM"), d.async = "false", d.loadXML(c))
            } catch(f) {
                d = b
            }
            return d && d.documentElement && !d.getElementsByTagName("parsererror").length || ib.error("Invalid XML: " + c),
            d
        },
        noop: function() {},
        globalEval: function(b) {
            b && ib.trim(b) && (a.execScript ||
            function(b) {
                a.eval.call(a, b)
            })(b)
        },
        camelCase: function(a) {
            return a.replace(sb, "ms-").replace(tb, ub)
        },
        nodeName: function(a, b) {
            return a.nodeName && a.nodeName.toLowerCase() === b.toLowerCase()
        },
        each: function(a, b, d) {
            var e, f = 0,
            g = a.length,
            h = c(a);
            if (d) {
                if (h) for (; g > f && (e = b.apply(a[f], d), e !== !1); f++);
                else for (f in a) if (e = b.apply(a[f], d), e === !1) break
            } else if (h) for (; g > f && (e = b.call(a[f], f, a[f]), e !== !1); f++);
            else for (f in a) if (e = b.call(a[f], f, a[f]), e === !1) break;
            return a
        },
        trim: hb && !hb.call("﻿ ") ?
        function(a) {
            return null == a ? "": hb.call(a)
        }: function(a) {
            return null == a ? "": (a + "").replace(lb, "")
        },
        makeArray: function(a, b) {
            var d = b || [];
            return null != a && (c(Object(a)) ? ib.merge(d, "string" == typeof a ? [a] : a) : cb.call(d, a)),
            d
        },
        inArray: function(a, b, c) {
            var d;
            if (b) {
                if (eb) return eb.call(b, a, c);
                for (d = b.length, c = c ? 0 > c ? Math.max(0, d + c) : c: 0; d > c; c++) if (c in b && b[c] === a) return c
            }
            return - 1
        },
        merge: function(a, c) {
            var d = c.length,
            e = a.length,
            f = 0;
            if ("number" == typeof d) for (; d > f; f++) a[e++] = c[f];
            else for (; c[f] !== b;) a[e++] = c[f++];
            return a.length = e,
            a
        },
        grep: function(a, b, c) {
            var d, e = [],
            f = 0,
            g = a.length;
            for (c = !!c; g > f; f++) d = !!b(a[f], f),
            c !== d && e.push(a[f]);
            return e
        },
        map: function(a, b, d) {
            var e, f = 0,
            g = a.length,
            h = c(a),
            i = [];
            if (h) for (; g > f; f++) e = b(a[f], f, d),
            null != e && (i[i.length] = e);
            else for (f in a) e = b(a[f], f, d),
            null != e && (i[i.length] = e);
            return bb.apply([], i)
        },
        guid: 1,
        proxy: function(a, c) {
            var d, e, f;
            return "string" == typeof c && (f = a[c], c = a, a = f),
            ib.isFunction(a) ? (d = db.call(arguments, 2), e = function() {
                return a.apply(c || this, d.concat(db.call(arguments)))
            },
            e.guid = a.guid = a.guid || ib.guid++, e) : b
        },
        access: function(a, c, d, e, f, g, h) {
            var i = 0,
            j = a.length,
            k = null == d;
            if ("object" === ib.type(d)) {
                f = !0;
                for (i in d) ib.access(a, c, i, d[i], !0, g, h)
            } else if (e !== b && (f = !0, ib.isFunction(e) || (h = !0), k && (h ? (c.call(a, e), c = null) : (k = c, c = function(a, b, c) {
                return k.call(ib(a), c)
            })), c)) for (; j > i; i++) c(a[i], d, h ? e: e.call(a[i], i, c(a[i], d)));
            return f ? a: k ? c.call(a) : j ? c(a[0], d) : g
        },
        now: function() {
            return (new Date).getTime()
        }
    }),
    ib.ready.promise = function(b) {
        if (!T) if (T = ib.Deferred(), "complete" === W.readyState) setTimeout(ib.ready);
        else if (W.addEventListener) W.addEventListener("DOMContentLoaded", vb, !1),
        a.addEventListener("load", vb, !1);
        else {
            W.attachEvent("onreadystatechange", vb),
            a.attachEvent("onload", vb);
            var c = !1;
            try {
                c = null == a.frameElement && W.documentElement
            } catch(d) {}
            c && c.doScroll && !
            function e() {
                if (!ib.isReady) {
                    try {
                        c.doScroll("left")
                    } catch(a) {
                        return setTimeout(e, 50)
                    }
                    wb(),
                    ib.ready()
                }
            } ()
        }
        return T.promise(b)
    },
    ib.each("Boolean Number String Function Array Date RegExp Object Error".split(" "),
    function(a, b) {
        $["[object " + b + "]"] = b.toLowerCase()
    }),
    U = ib(W);
    var xb = {};
    ib.Callbacks = function(a) {
        a = "string" == typeof a ? xb[a] || d(a) : ib.extend({},
        a);
        var c, e, f, g, h, i, j = [],
        k = !a.once && [],
        l = function(b) {
            for (e = a.memory && b, f = !0, h = i || 0, i = 0, g = j.length, c = !0; j && g > h; h++) if (j[h].apply(b[0], b[1]) === !1 && a.stopOnFalse) {
                e = !1;
                break
            }
            c = !1,
            j && (k ? k.length && l(k.shift()) : e ? j = [] : m.disable())
        },
        m = {
            add: function() {
                if (j) {
                    var b = j.length; !
                    function d(b) {
                        ib.each(b,
                        function(b, c) {
                            var e = ib.type(c);
                            "function" === e ? a.unique && m.has(c) || j.push(c) : c && c.length && "string" !== e && d(c)
                        })
                    } (arguments),
                    c ? g = j.length: e && (i = b, l(e))
                }
                return this
            },
            remove: function() {
                return j && ib.each(arguments,
                function(a, b) {
                    for (var d; (d = ib.inArray(b, j, d)) > -1;) j.splice(d, 1),
                    c && (g >= d && g--, h >= d && h--)
                }),
                this
            },
            has: function(a) {
                return a ? ib.inArray(a, j) > -1 : !(!j || !j.length)
            },
            empty: function() {
                return j = [],
                this
            },
            disable: function() {
                return j = k = e = b,
                this
            },
            disabled: function() {
                return ! j
            },
            lock: function() {
                return k = b,
                e || m.disable(),
                this
            },
            locked: function() {
                return ! k
            },
            fireWith: function(a, b) {
                return b = b || [],
                b = [a, b.slice ? b.slice() : b],
                !j || f && !k || (c ? k.push(b) : l(b)),
                this
            },
            fire: function() {
                return m.fireWith(this, arguments),
                this
            },
            fired: function() {
                return !! f
            }
        };
        return m
    },
    ib.extend({
        Deferred: function(a) {
            var b = [["resolve", "done", ib.Callbacks("once memory"), "resolved"], ["reject", "fail", ib.Callbacks("once memory"), "rejected"], ["notify", "progress", ib.Callbacks("memory")]],
            c = "pending",
            d = {
                state: function() {
                    return c
                },
                always: function() {
                    return e.done(arguments).fail(arguments),
                    this
                },
                then: function() {
                    var a = arguments;
                    return ib.Deferred(function(c) {
                        ib.each(b,
                        function(b, f) {
                            var g = f[0],
                            h = ib.isFunction(a[b]) && a[b];
                            e[f[1]](function() {
                                var a = h && h.apply(this, arguments);
                                a && ib.isFunction(a.promise) ? a.promise().done(c.resolve).fail(c.reject).progress(c.notify) : c[g + "With"](this === d ? c.promise() : this, h ? [a] : arguments)
                            })
                        }),
                        a = null
                    }).promise()
                },
                promise: function(a) {
                    return null != a ? ib.extend(a, d) : d
                }
            },
            e = {};
            return d.pipe = d.then,
            ib.each(b,
            function(a, f) {
                var g = f[2],
                h = f[3];
                d[f[1]] = g.add,
                h && g.add(function() {
                    c = h
                },
                b[1 ^ a][2].disable, b[2][2].lock),
                e[f[0]] = function() {
                    return e[f[0] + "With"](this === e ? d: this, arguments),
                    this
                },
                e[f[0] + "With"] = g.fireWith
            }),
            d.promise(e),
            a && a.call(e, e),
            e
        },
        when: function(a) {
            var b, c, d, e = 0,
            f = db.call(arguments),
            g = f.length,
            h = 1 !== g || a && ib.isFunction(a.promise) ? g: 0,
            i = 1 === h ? a: ib.Deferred(),
            j = function(a, c, d) {
                return function(e) {
                    c[a] = this,
                    d[a] = arguments.length > 1 ? db.call(arguments) : e,
                    d === b ? i.notifyWith(c, d) : --h || i.resolveWith(c, d)
                }
            };
            if (g > 1) for (b = new Array(g), c = new Array(g), d = new Array(g); g > e; e++) f[e] && ib.isFunction(f[e].promise) ? f[e].promise().done(j(e, d, f)).fail(i.reject).progress(j(e, c, b)) : --h;
            return h || i.resolveWith(d, f),
            i.promise()
        }
    }),
    ib.support = function() {
        var b, c, d, e, f, g, h, i, j, k, l = W.createElement("div");
        if (l.setAttribute("className", "t"), l.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", c = l.getElementsByTagName("*"), d = l.getElementsByTagName("a")[0], !c || !d || !c.length) return {};
        f = W.createElement("select"),
        h = f.appendChild(W.createElement("option")),
        e = l.getElementsByTagName("input")[0],
        d.style.cssText = "top:1px;float:left;opacity:.5",
        b = {
            getSetAttribute: "t" !== l.className,
            leadingWhitespace: 3 === l.firstChild.nodeType,
            tbody: !l.getElementsByTagName("tbody").length,
            htmlSerialize: !!l.getElementsByTagName("link").length,
            style: /top/.test(d.getAttribute("style")),
            hrefNormalized: "/a" === d.getAttribute("href"),
            opacity: /^0.5/.test(d.style.opacity),
            cssFloat: !!d.style.cssFloat,
            checkOn: !!e.value,
            optSelected: h.selected,
            enctype: !!W.createElement("form").enctype,
            html5Clone: "<:nav></:nav>" !== W.createElement("nav").cloneNode(!0).outerHTML,
            boxModel: "CSS1Compat" === W.compatMode,
            deleteExpando: !0,
            noCloneEvent: !0,
            inlineBlockNeedsLayout: !1,
            shrinkWrapBlocks: !1,
            reliableMarginRight: !0,
            boxSizingReliable: !0,
            pixelPosition: !1
        },
        e.checked = !0,
        b.noCloneChecked = e.cloneNode(!0).checked,
        f.disabled = !0,
        b.optDisabled = !h.disabled;
        try {
            delete l.test
        } catch(m) {
            b.deleteExpando = !1
        }
        e = W.createElement("input"),
        e.setAttribute("value", ""),
        b.input = "" === e.getAttribute("value"),
        e.value = "t",
        e.setAttribute("type", "radio"),
        b.radioValue = "t" === e.value,
        e.setAttribute("checked", "t"),
        e.setAttribute("name", "t"),
        g = W.createDocumentFragment(),
        g.appendChild(e),
        b.appendChecked = e.checked,
        b.checkClone = g.cloneNode(!0).cloneNode(!0).lastChild.checked,
        l.attachEvent && (l.attachEvent("onclick",
        function() {
            b.noCloneEvent = !1
        }), l.cloneNode(!0).click());
        for (k in {
            submit: !0,
            change: !0,
            focusin: !0
        }) l.setAttribute(i = "on" + k, "t"),
        b[k + "Bubbles"] = i in a || l.attributes[i].expando === !1;
        return l.style.backgroundClip = "content-box",
        l.cloneNode(!0).style.backgroundClip = "",
        b.clearCloneStyle = "content-box" === l.style.backgroundClip,
        ib(function() {
            var c, d, e, f = "padding:0;margin:0;border:0;display:block;box-sizing:content-box;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;",
            g = W.getElementsByTagName("body")[0];
            g && (c = W.createElement("div"), c.style.cssText = "border:0;width:0;height:0;position:absolute;top:0;left:-9999px;margin-top:1px", g.appendChild(c).appendChild(l), l.innerHTML = "<table><tr><td></td><td>t</td></tr></table>", e = l.getElementsByTagName("td"), e[0].style.cssText = "padding:0;margin:0;border:0;display:none", j = 0 === e[0].offsetHeight, e[0].style.display = "", e[1].style.display = "none", b.reliableHiddenOffsets = j && 0 === e[0].offsetHeight, l.innerHTML = "", l.style.cssText = "box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;padding:1px;border:1px;display:block;width:4px;margin-top:1%;position:absolute;top:1%;", b.boxSizing = 4 === l.offsetWidth, b.doesNotIncludeMarginInBodyOffset = 1 !== g.offsetTop, a.getComputedStyle && (b.pixelPosition = "1%" !== (a.getComputedStyle(l, null) || {}).top, b.boxSizingReliable = "4px" === (a.getComputedStyle(l, null) || {
                width: "4px"
            }).width, d = l.appendChild(W.createElement("div")), d.style.cssText = l.style.cssText = f, d.style.marginRight = d.style.width = "0", l.style.width = "1px", b.reliableMarginRight = !parseFloat((a.getComputedStyle(d, null) || {}).marginRight)), typeof l.style.zoom !== V && (l.innerHTML = "", l.style.cssText = f + "width:1px;padding:1px;display:inline;zoom:1", b.inlineBlockNeedsLayout = 3 === l.offsetWidth, l.style.display = "block", l.innerHTML = "<div></div>", l.firstChild.style.width = "5px", b.shrinkWrapBlocks = 3 !== l.offsetWidth, b.inlineBlockNeedsLayout && (g.style.zoom = 1)), g.removeChild(c), c = l = e = d = null)
        }),
        c = f = g = h = d = e = null,
        b
    } ();
    var yb = /(?:\{[\s\S]*\}|\[[\s\S]*\])$/,
    zb = /([A-Z])/g;
    ib.extend({
        cache: {},
        expando: "jQuery" + (ab + Math.random()).replace(/\D/g, ""),
        noData: {
            embed: !0,
            object: "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000",
            applet: !0
        },
        hasData: function(a) {
            return a = a.nodeType ? ib.cache[a[ib.expando]] : a[ib.expando],
            !!a && !h(a)
        },
        data: function(a, b, c) {
            return e(a, b, c)
        },
        removeData: function(a, b) {
            return f(a, b)
        },
        _data: function(a, b, c) {
            return e(a, b, c, !0)
        },
        _removeData: function(a, b) {
            return f(a, b, !0)
        },
        acceptData: function(a) {
            if (a.nodeType && 1 !== a.nodeType && 9 !== a.nodeType) return ! 1;
            var b = a.nodeName && ib.noData[a.nodeName.toLowerCase()];
            return ! b || b !== !0 && a.getAttribute("classid") === b
        }
    }),
    ib.fn.extend({
        data: function(a, c) {
            var d, e, f = this[0],
            h = 0,
            i = null;
            if (a === b) {
                if (this.length && (i = ib.data(f), 1 === f.nodeType && !ib._data(f, "parsedAttrs"))) {
                    for (d = f.attributes; h < d.length; h++) e = d[h].name,
                    e.indexOf("data-") || (e = ib.camelCase(e.slice(5)), g(f, e, i[e]));
                    ib._data(f, "parsedAttrs", !0)
                }
                return i
            }
            return "object" == typeof a ? this.each(function() {
                ib.data(this, a)
            }) : ib.access(this,
            function(c) {
                return c === b ? f ? g(f, a, ib.data(f, a)) : null: void this.each(function() {
                    ib.data(this, a, c)
                })
            },
            null, c, arguments.length > 1, null, !0)
        },
        removeData: function(a) {
            return this.each(function() {
                ib.removeData(this, a)
            })
        }
    }),
    ib.extend({
        queue: function(a, b, c) {
            var d;
            return a ? (b = (b || "fx") + "queue", d = ib._data(a, b), c && (!d || ib.isArray(c) ? d = ib._data(a, b, ib.makeArray(c)) : d.push(c)), d || []) : void 0
        },
        dequeue: function(a, b) {
            b = b || "fx";
            var c = ib.queue(a, b),
            d = c.length,
            e = c.shift(),
            f = ib._queueHooks(a, b),
            g = function() {
                ib.dequeue(a, b)
            };
            "inprogress" === e && (e = c.shift(), d--),
            f.cur = e,
            e && ("fx" === b && c.unshift("inprogress"), delete f.stop, e.call(a, g, f)),
            !d && f && f.empty.fire()
        },
        _queueHooks: function(a, b) {
            var c = b + "queueHooks";
            return ib._data(a, c) || ib._data(a, c, {
                empty: ib.Callbacks("once memory").add(function() {
                    ib._removeData(a, b + "queue"),
                    ib._removeData(a, c)
                })
            })
        }
    }),
    ib.fn.extend({
        queue: function(a, c) {
            var d = 2;
            return "string" != typeof a && (c = a, a = "fx", d--),
            arguments.length < d ? ib.queue(this[0], a) : c === b ? this: this.each(function() {
                var b = ib.queue(this, a, c);
                ib._queueHooks(this, a),
                "fx" === a && "inprogress" !== b[0] && ib.dequeue(this, a)
            })
        },
        dequeue: function(a) {
            return this.each(function() {
                ib.dequeue(this, a)
            })
        },
        delay: function(a, b) {
            return a = ib.fx ? ib.fx.speeds[a] || a: a,
            b = b || "fx",
            this.queue(b,
            function(b, c) {
                var d = setTimeout(b, a);
                c.stop = function() {
                    clearTimeout(d)
                }
            })
        },
        clearQueue: function(a) {
            return this.queue(a || "fx", [])
        },
        promise: function(a, c) {
            var d, e = 1,
            f = ib.Deferred(),
            g = this,
            h = this.length,
            i = function() {--e || f.resolveWith(g, [g])
            };
            for ("string" != typeof a && (c = a, a = b), a = a || "fx"; h--;) d = ib._data(g[h], a + "queueHooks"),
            d && d.empty && (e++, d.empty.add(i));
            return i(),
            f.promise(c)
        }
    });
    var Ab, Bb, Cb = /[\t\r\n]/g,
    Db = /\r/g,
    Eb = /^(?:input|select|textarea|button|object)$/i,
    Fb = /^(?:a|area)$/i,
    Gb = /^(?:checked|selected|autofocus|autoplay|async|controls|defer|disabled|hidden|loop|multiple|open|readonly|required|scoped)$/i,
    Hb = /^(?:checked|selected)$/i,
    Ib = ib.support.getSetAttribute,
    Jb = ib.support.input;
    ib.fn.extend({
        attr: function(a, b) {
            return ib.access(this, ib.attr, a, b, arguments.length > 1)
        },
        removeAttr: function(a) {
            return this.each(function() {
                ib.removeAttr(this, a)
            })
        },
        prop: function(a, b) {
            return ib.access(this, ib.prop, a, b, arguments.length > 1)
        },
        removeProp: function(a) {
            return a = ib.propFix[a] || a,
            this.each(function() {
                try {
                    this[a] = b,
                    delete this[a]
                } catch(c) {}
            })
        },
        addClass: function(a) {
            var b, c, d, e, f, g = 0,
            h = this.length,
            i = "string" == typeof a && a;
            if (ib.isFunction(a)) return this.each(function(b) {
                ib(this).addClass(a.call(this, b, this.className))
            });
            if (i) for (b = (a || "").match(kb) || []; h > g; g++) if (c = this[g], d = 1 === c.nodeType && (c.className ? (" " + c.className + " ").replace(Cb, " ") : " ")) {
                for (f = 0; e = b[f++];) d.indexOf(" " + e + " ") < 0 && (d += e + " ");
                c.className = ib.trim(d)
            }
            return this
        },
        removeClass: function(a) {
            var b, c, d, e, f, g = 0,
            h = this.length,
            i = 0 === arguments.length || "string" == typeof a && a;
            if (ib.isFunction(a)) return this.each(function(b) {
                ib(this).removeClass(a.call(this, b, this.className))
            });
            if (i) for (b = (a || "").match(kb) || []; h > g; g++) if (c = this[g], d = 1 === c.nodeType && (c.className ? (" " + c.className + " ").replace(Cb, " ") : "")) {
                for (f = 0; e = b[f++];) for (; d.indexOf(" " + e + " ") >= 0;) d = d.replace(" " + e + " ", " ");
                c.className = a ? ib.trim(d) : ""
            }
            return this
        },
        toggleClass: function(a, b) {
            var c = typeof a,
            d = "boolean" == typeof b;
            return this.each(ib.isFunction(a) ?
            function(c) {
                ib(this).toggleClass(a.call(this, c, this.className, b), b)
            }: function() {
                if ("string" === c) for (var e, f = 0,
                g = ib(this), h = b, i = a.match(kb) || []; e = i[f++];) h = d ? h: !g.hasClass(e),
                g[h ? "addClass": "removeClass"](e);
                else(c === V || "boolean" === c) && (this.className && ib._data(this, "__className__", this.className), this.className = this.className || a === !1 ? "": ib._data(this, "__className__") || "")
            })
        },
        hasClass: function(a) {
            for (var b = " " + a + " ",
            c = 0,
            d = this.length; d > c; c++) if (1 === this[c].nodeType && (" " + this[c].className + " ").replace(Cb, " ").indexOf(b) >= 0) return ! 0;
            return ! 1
        },
        val: function(a) {
            var c, d, e, f = this[0]; {
                if (arguments.length) return e = ib.isFunction(a),
                this.each(function(c) {
                    var f, g = ib(this);
                    1 === this.nodeType && (f = e ? a.call(this, c, g.val()) : a, null == f ? f = "": "number" == typeof f ? f += "": ib.isArray(f) && (f = ib.map(f,
                    function(a) {
                        return null == a ? "": a + ""
                    })), d = ib.valHooks[this.type] || ib.valHooks[this.nodeName.toLowerCase()], d && "set" in d && d.set(this, f, "value") !== b || (this.value = f))
                });
                if (f) return d = ib.valHooks[f.type] || ib.valHooks[f.nodeName.toLowerCase()],
                d && "get" in d && (c = d.get(f, "value")) !== b ? c: (c = f.value, "string" == typeof c ? c.replace(Db, "") : null == c ? "": c)
            }
        }
    }),
    ib.extend({
        valHooks: {
            option: {
                get: function(a) {
                    var b = a.attributes.value;
                    return ! b || b.specified ? a.value: a.text
                }
            },
            select: {
                get: function(a) {
                    for (var b, c, d = a.options,
                    e = a.selectedIndex,
                    f = "select-one" === a.type || 0 > e,
                    g = f ? null: [], h = f ? e + 1 : d.length, i = 0 > e ? h: f ? e: 0; h > i; i++) if (c = d[i], !(!c.selected && i !== e || (ib.support.optDisabled ? c.disabled: null !== c.getAttribute("disabled")) || c.parentNode.disabled && ib.nodeName(c.parentNode, "optgroup"))) {
                        if (b = ib(c).val(), f) return b;
                        g.push(b)
                    }
                    return g
                },
                set: function(a, b) {
                    var c = ib.makeArray(b);
                    return ib(a).find("option").each(function() {
                        this.selected = ib.inArray(ib(this).val(), c) >= 0
                    }),
                    c.length || (a.selectedIndex = -1),
                    c
                }
            }
        },
        attr: function(a, c, d) {
            var e, f, g, h = a.nodeType;
            if (a && 3 !== h && 8 !== h && 2 !== h) return typeof a.getAttribute === V ? ib.prop(a, c, d) : (f = 1 !== h || !ib.isXMLDoc(a), f && (c = c.toLowerCase(), e = ib.attrHooks[c] || (Gb.test(c) ? Bb: Ab)), d === b ? e && f && "get" in e && null !== (g = e.get(a, c)) ? g: (typeof a.getAttribute !== V && (g = a.getAttribute(c)), null == g ? b: g) : null !== d ? e && f && "set" in e && (g = e.set(a, d, c)) !== b ? g: (a.setAttribute(c, d + ""), d) : void ib.removeAttr(a, c))
        },
        removeAttr: function(a, b) {
            var c, d, e = 0,
            f = b && b.match(kb);
            if (f && 1 === a.nodeType) for (; c = f[e++];) d = ib.propFix[c] || c,
            Gb.test(c) ? !Ib && Hb.test(c) ? a[ib.camelCase("default-" + c)] = a[d] = !1 : a[d] = !1 : ib.attr(a, c, ""),
            a.removeAttribute(Ib ? c: d)
        },
        attrHooks: {
            type: {
                set: function(a, b) {
                    if (!ib.support.radioValue && "radio" === b && ib.nodeName(a, "input")) {
                        var c = a.value;
                        return a.setAttribute("type", b),
                        c && (a.value = c),
                        b
                    }
                }
            }
        },
        propFix: {
            tabindex: "tabIndex",
            readonly: "readOnly",
            "for": "htmlFor",
            "class": "className",
            maxlength: "maxLength",
            cellspacing: "cellSpacing",
            cellpadding: "cellPadding",
            rowspan: "rowSpan",
            colspan: "colSpan",
            usemap: "useMap",
            frameborder: "frameBorder",
            contenteditable: "contentEditable"
        },
        prop: function(a, c, d) {
            var e, f, g, h = a.nodeType;
            if (a && 3 !== h && 8 !== h && 2 !== h) return g = 1 !== h || !ib.isXMLDoc(a),
            g && (c = ib.propFix[c] || c, f = ib.propHooks[c]),
            d !== b ? f && "set" in f && (e = f.set(a, d, c)) !== b ? e: a[c] = d: f && "get" in f && null !== (e = f.get(a, c)) ? e: a[c]
        },
        propHooks: {
            tabIndex: {
                get: function(a) {
                    var c = a.getAttributeNode("tabindex");
                    return c && c.specified ? parseInt(c.value, 10) : Eb.test(a.nodeName) || Fb.test(a.nodeName) && a.href ? 0 : b
                }
            }
        }
    }),
    Bb = {
        get: function(a, c) {
            var d = ib.prop(a, c),
            e = "boolean" == typeof d && a.getAttribute(c),
            f = "boolean" == typeof d ? Jb && Ib ? null != e: Hb.test(c) ? a[ib.camelCase("default-" + c)] : !!e: a.getAttributeNode(c);
            return f && f.value !== !1 ? c.toLowerCase() : b
        },
        set: function(a, b, c) {
            return b === !1 ? ib.removeAttr(a, c) : Jb && Ib || !Hb.test(c) ? a.setAttribute(!Ib && ib.propFix[c] || c, c) : a[ib.camelCase("default-" + c)] = a[c] = !0,
            c
        }
    },
    Jb && Ib || (ib.attrHooks.value = {
        get: function(a, c) {
            var d = a.getAttributeNode(c);
            return ib.nodeName(a, "input") ? a.defaultValue: d && d.specified ? d.value: b
        },
        set: function(a, b, c) {
            return ib.nodeName(a, "input") ? void(a.defaultValue = b) : Ab && Ab.set(a, b, c)
        }
    }),
    Ib || (Ab = ib.valHooks.button = {
        get: function(a, c) {
            var d = a.getAttributeNode(c);
            return d && ("id" === c || "name" === c || "coords" === c ? "" !== d.value: d.specified) ? d.value: b
        },
        set: function(a, c, d) {
            var e = a.getAttributeNode(d);
            return e || a.setAttributeNode(e = a.ownerDocument.createAttribute(d)),
            e.value = c += "",
            "value" === d || c === a.getAttribute(d) ? c: b
        }
    },
    ib.attrHooks.contenteditable = {
        get: Ab.get,
        set: function(a, b, c) {
            Ab.set(a, "" === b ? !1 : b, c)
        }
    },
    ib.each(["width", "height"],
    function(a, b) {
        ib.attrHooks[b] = ib.extend(ib.attrHooks[b], {
            set: function(a, c) {
                return "" === c ? (a.setAttribute(b, "auto"), c) : void 0
            }
        })
    })),
    ib.support.hrefNormalized || (ib.each(["href", "src", "width", "height"],
    function(a, c) {
        ib.attrHooks[c] = ib.extend(ib.attrHooks[c], {
            get: function(a) {
                var d = a.getAttribute(c, 2);
                return null == d ? b: d
            }
        })
    }), ib.each(["href", "src"],
    function(a, b) {
        ib.propHooks[b] = {
            get: function(a) {
                return a.getAttribute(b, 4)
            }
        }
    })),
    ib.support.style || (ib.attrHooks.style = {
        get: function(a) {
            return a.style.cssText || b
        },
        set: function(a, b) {
            return a.style.cssText = b + ""
        }
    }),
    ib.support.optSelected || (ib.propHooks.selected = ib.extend(ib.propHooks.selected, {
        get: function(a) {
            var b = a.parentNode;
            return b && (b.selectedIndex, b.parentNode && b.parentNode.selectedIndex),
            null
        }
    })),
    ib.support.enctype || (ib.propFix.enctype = "encoding"),
    ib.support.checkOn || ib.each(["radio", "checkbox"],
    function() {
        ib.valHooks[this] = {
            get: function(a) {
                return null === a.getAttribute("value") ? "on": a.value
            }
        }
    }),
    ib.each(["radio", "checkbox"],
    function() {
        ib.valHooks[this] = ib.extend(ib.valHooks[this], {
            set: function(a, b) {
                return ib.isArray(b) ? a.checked = ib.inArray(ib(a).val(), b) >= 0 : void 0
            }
        })
    });
    var Kb = /^(?:input|select|textarea)$/i,
    Lb = /^key/,
    Mb = /^(?:mouse|contextmenu)|click/,
    Nb = /^(?:focusinfocus|focusoutblur)$/,
    Ob = /^([^.]*)(?:\.(.+)|)$/;
    ib.event = {
        global: {},
        add: function(a, c, d, e, f) {
            var g, h, i, j, k, l, m, n, o, p, q, r = ib._data(a);
            if (r) {
                for (d.handler && (j = d, d = j.handler, f = j.selector), d.guid || (d.guid = ib.guid++), (h = r.events) || (h = r.events = {}), (l = r.handle) || (l = r.handle = function(a) {
                    return typeof ib === V || a && ib.event.triggered === a.type ? b: ib.event.dispatch.apply(l.elem, arguments)
                },
                l.elem = a), c = (c || "").match(kb) || [""], i = c.length; i--;) g = Ob.exec(c[i]) || [],
                o = q = g[1],
                p = (g[2] || "").split(".").sort(),
                k = ib.event.special[o] || {},
                o = (f ? k.delegateType: k.bindType) || o,
                k = ib.event.special[o] || {},
                m = ib.extend({
                    type: o,
                    origType: q,
                    data: e,
                    handler: d,
                    guid: d.guid,
                    selector: f,
                    needsContext: f && ib.expr.match.needsContext.test(f),
                    namespace: p.join(".")
                },
                j),
                (n = h[o]) || (n = h[o] = [], n.delegateCount = 0, k.setup && k.setup.call(a, e, p, l) !== !1 || (a.addEventListener ? a.addEventListener(o, l, !1) : a.attachEvent && a.attachEvent("on" + o, l))),
                k.add && (k.add.call(a, m), m.handler.guid || (m.handler.guid = d.guid)),
                f ? n.splice(n.delegateCount++, 0, m) : n.push(m),
                ib.event.global[o] = !0;
                a = null
            }
        },
        remove: function(a, b, c, d, e) {
            var f, g, h, i, j, k, l, m, n, o, p, q = ib.hasData(a) && ib._data(a);
            if (q && (k = q.events)) {
                for (b = (b || "").match(kb) || [""], j = b.length; j--;) if (h = Ob.exec(b[j]) || [], n = p = h[1], o = (h[2] || "").split(".").sort(), n) {
                    for (l = ib.event.special[n] || {},
                    n = (d ? l.delegateType: l.bindType) || n, m = k[n] || [], h = h[2] && new RegExp("(^|\\.)" + o.join("\\.(?:.*\\.|)") + "(\\.|$)"), i = f = m.length; f--;) g = m[f],
                    !e && p !== g.origType || c && c.guid !== g.guid || h && !h.test(g.namespace) || d && d !== g.selector && ("**" !== d || !g.selector) || (m.splice(f, 1), g.selector && m.delegateCount--, l.remove && l.remove.call(a, g));
                    i && !m.length && (l.teardown && l.teardown.call(a, o, q.handle) !== !1 || ib.removeEvent(a, n, q.handle), delete k[n])
                } else for (n in k) ib.event.remove(a, n + b[j], c, d, !0);
                ib.isEmptyObject(k) && (delete q.handle, ib._removeData(a, "events"))
            }
        },
        trigger: function(c, d, e, f) {
            var g, h, i, j, k, l, m, n = [e || W],
            o = gb.call(c, "type") ? c.type: c,
            p = gb.call(c, "namespace") ? c.namespace.split(".") : [];
            if (i = l = e = e || W, 3 !== e.nodeType && 8 !== e.nodeType && !Nb.test(o + ib.event.triggered) && (o.indexOf(".") >= 0 && (p = o.split("."), o = p.shift(), p.sort()), h = o.indexOf(":") < 0 && "on" + o, c = c[ib.expando] ? c: new ib.Event(o, "object" == typeof c && c), c.isTrigger = !0, c.namespace = p.join("."), c.namespace_re = c.namespace ? new RegExp("(^|\\.)" + p.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, c.result = b, c.target || (c.target = e), d = null == d ? [c] : ib.makeArray(d, [c]), k = ib.event.special[o] || {},
            f || !k.trigger || k.trigger.apply(e, d) !== !1)) {
                if (!f && !k.noBubble && !ib.isWindow(e)) {
                    for (j = k.delegateType || o, Nb.test(j + o) || (i = i.parentNode); i; i = i.parentNode) n.push(i),
                    l = i;
                    l === (e.ownerDocument || W) && n.push(l.defaultView || l.parentWindow || a)
                }
                for (m = 0; (i = n[m++]) && !c.isPropagationStopped();) c.type = m > 1 ? j: k.bindType || o,
                g = (ib._data(i, "events") || {})[c.type] && ib._data(i, "handle"),
                g && g.apply(i, d),
                g = h && i[h],
                g && ib.acceptData(i) && g.apply && g.apply(i, d) === !1 && c.preventDefault();
                if (c.type = o, !(f || c.isDefaultPrevented() || k._default && k._default.apply(e.ownerDocument, d) !== !1 || "click" === o && ib.nodeName(e, "a") || !ib.acceptData(e) || !h || !e[o] || ib.isWindow(e))) {
                    l = e[h],
                    l && (e[h] = null),
                    ib.event.triggered = o;
                    try {
                        e[o]()
                    } catch(q) {}
                    ib.event.triggered = b,
                    l && (e[h] = l)
                }
                return c.result
            }
        },
        dispatch: function(a) {
            a = ib.event.fix(a);
            var c, d, e, f, g, h = [],
            i = db.call(arguments),
            j = (ib._data(this, "events") || {})[a.type] || [],
            k = ib.event.special[a.type] || {};
            if (i[0] = a, a.delegateTarget = this, !k.preDispatch || k.preDispatch.call(this, a) !== !1) {
                for (h = ib.event.handlers.call(this, a, j), c = 0; (f = h[c++]) && !a.isPropagationStopped();) for (a.currentTarget = f.elem, g = 0; (e = f.handlers[g++]) && !a.isImmediatePropagationStopped();)(!a.namespace_re || a.namespace_re.test(e.namespace)) && (a.handleObj = e, a.data = e.data, d = ((ib.event.special[e.origType] || {}).handle || e.handler).apply(f.elem, i), d !== b && (a.result = d) === !1 && (a.preventDefault(), a.stopPropagation()));
                return k.postDispatch && k.postDispatch.call(this, a),
                a.result
            }
        },
        handlers: function(a, c) {
            var d, e, f, g, h = [],
            i = c.delegateCount,
            j = a.target;
            if (i && j.nodeType && (!a.button || "click" !== a.type)) for (; j != this; j = j.parentNode || this) if (1 === j.nodeType && (j.disabled !== !0 || "click" !== a.type)) {
                for (f = [], g = 0; i > g; g++) e = c[g],
                d = e.selector + " ",
                f[d] === b && (f[d] = e.needsContext ? ib(d, this).index(j) >= 0 : ib.find(d, this, null, [j]).length),
                f[d] && f.push(e);
                f.length && h.push({
                    elem: j,
                    handlers: f
                })
            }
            return i < c.length && h.push({
                elem: this,
                handlers: c.slice(i)
            }),
            h
        },
        fix: function(a) {
            if (a[ib.expando]) return a;
            var b, c, d, e = a.type,
            f = a,
            g = this.fixHooks[e];
            for (g || (this.fixHooks[e] = g = Mb.test(e) ? this.mouseHooks: Lb.test(e) ? this.keyHooks: {}), d = g.props ? this.props.concat(g.props) : this.props, a = new ib.Event(f), b = d.length; b--;) c = d[b],
            a[c] = f[c];
            return a.target || (a.target = f.srcElement || W),
            3 === a.target.nodeType && (a.target = a.target.parentNode),
            a.metaKey = !!a.metaKey,
            g.filter ? g.filter(a, f) : a
        },
        props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
        fixHooks: {},
        keyHooks: {
            props: "char charCode key keyCode".split(" "),
            filter: function(a, b) {
                return null == a.which && (a.which = null != b.charCode ? b.charCode: b.keyCode),
                a
            }
        },
        mouseHooks: {
            props: "button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
            filter: function(a, c) {
                var d, e, f, g = c.button,
                h = c.fromElement;
                return null == a.pageX && null != c.clientX && (e = a.target.ownerDocument || W, f = e.documentElement, d = e.body, a.pageX = c.clientX + (f && f.scrollLeft || d && d.scrollLeft || 0) - (f && f.clientLeft || d && d.clientLeft || 0), a.pageY = c.clientY + (f && f.scrollTop || d && d.scrollTop || 0) - (f && f.clientTop || d && d.clientTop || 0)),
                !a.relatedTarget && h && (a.relatedTarget = h === a.target ? c.toElement: h),
                a.which || g === b || (a.which = 1 & g ? 1 : 2 & g ? 3 : 4 & g ? 2 : 0),
                a
            }
        },
        special: {
            load: {
                noBubble: !0
            },
            click: {
                trigger: function() {
                    return ib.nodeName(this, "input") && "checkbox" === this.type && this.click ? (this.click(), !1) : void 0
                }
            },
            focus: {
                trigger: function() {
                    if (this !== W.activeElement && this.focus) try {
                        return this.focus(),
                        !1
                    } catch(a) {}
                },
                delegateType: "focusin"
            },
            blur: {
                trigger: function() {
                    return this === W.activeElement && this.blur ? (this.blur(), !1) : void 0
                },
                delegateType: "focusout"
            },
            beforeunload: {
                postDispatch: function(a) {
                    a.result !== b && (a.originalEvent.returnValue = a.result)
                }
            }
        },
        simulate: function(a, b, c, d) {
            var e = ib.extend(new ib.Event, c, {
                type: a,
                isSimulated: !0,
                originalEvent: {}
            });
            d ? ib.event.trigger(e, null, b) : ib.event.dispatch.call(b, e),
            e.isDefaultPrevented() && c.preventDefault()
        }
    },
    ib.removeEvent = W.removeEventListener ?
    function(a, b, c) {
        a.removeEventListener && a.removeEventListener(b, c, !1)
    }: function(a, b, c) {
        var d = "on" + b;
        a.detachEvent && (typeof a[d] === V && (a[d] = null), a.detachEvent(d, c))
    },
    ib.Event = function(a, b) {
        return this instanceof ib.Event ? (a && a.type ? (this.originalEvent = a, this.type = a.type, this.isDefaultPrevented = a.defaultPrevented || a.returnValue === !1 || a.getPreventDefault && a.getPreventDefault() ? i: j) : this.type = a, b && ib.extend(this, b), this.timeStamp = a && a.timeStamp || ib.now(), void(this[ib.expando] = !0)) : new ib.Event(a, b)
    },
    ib.Event.prototype = {
        isDefaultPrevented: j,
        isPropagationStopped: j,
        isImmediatePropagationStopped: j,
        preventDefault: function() {
            var a = this.originalEvent;
            this.isDefaultPrevented = i,
            a && (a.preventDefault ? a.preventDefault() : a.returnValue = !1)
        },
        stopPropagation: function() {
            var a = this.originalEvent;
            this.isPropagationStopped = i,
            a && (a.stopPropagation && a.stopPropagation(), a.cancelBubble = !0)
        },
        stopImmediatePropagation: function() {
            this.isImmediatePropagationStopped = i,
            this.stopPropagation()
        }
    },
    ib.each({
        mouseenter: "mouseover",
        mouseleave: "mouseout"
    },
    function(a, b) {
        ib.event.special[a] = {
            delegateType: b,
            bindType: b,
            handle: function(a) {
                var c, d = this,
                e = a.relatedTarget,
                f = a.handleObj;
                return (!e || e !== d && !ib.contains(d, e)) && (a.type = f.origType, c = f.handler.apply(this, arguments), a.type = b),
                c
            }
        }
    }),
    ib.support.submitBubbles || (ib.event.special.submit = {
        setup: function() {
            return ib.nodeName(this, "form") ? !1 : void ib.event.add(this, "click._submit keypress._submit",
            function(a) {
                var c = a.target,
                d = ib.nodeName(c, "input") || ib.nodeName(c, "button") ? c.form: b;
                d && !ib._data(d, "submitBubbles") && (ib.event.add(d, "submit._submit",
                function(a) {
                    a._submit_bubble = !0
                }), ib._data(d, "submitBubbles", !0))
            })
        },
        postDispatch: function(a) {
            a._submit_bubble && (delete a._submit_bubble, this.parentNode && !a.isTrigger && ib.event.simulate("submit", this.parentNode, a, !0))
        },
        teardown: function() {
            return ib.nodeName(this, "form") ? !1 : void ib.event.remove(this, "._submit")
        }
    }),
    ib.support.changeBubbles || (ib.event.special.change = {
        setup: function() {
            return Kb.test(this.nodeName) ? (("checkbox" === this.type || "radio" === this.type) && (ib.event.add(this, "propertychange._change",
            function(a) {
                "checked" === a.originalEvent.propertyName && (this._just_changed = !0)
            }), ib.event.add(this, "click._change",
            function(a) {
                this._just_changed && !a.isTrigger && (this._just_changed = !1),
                ib.event.simulate("change", this, a, !0)
            })), !1) : void ib.event.add(this, "beforeactivate._change",
            function(a) {
                var b = a.target;
                Kb.test(b.nodeName) && !ib._data(b, "changeBubbles") && (ib.event.add(b, "change._change",
                function(a) { ! this.parentNode || a.isSimulated || a.isTrigger || ib.event.simulate("change", this.parentNode, a, !0)
                }), ib._data(b, "changeBubbles", !0))
            })
        },
        handle: function(a) {
            var b = a.target;
            return this !== b || a.isSimulated || a.isTrigger || "radio" !== b.type && "checkbox" !== b.type ? a.handleObj.handler.apply(this, arguments) : void 0
        },
        teardown: function() {
            return ib.event.remove(this, "._change"),
            !Kb.test(this.nodeName)
        }
    }),
    ib.support.focusinBubbles || ib.each({
        focus: "focusin",
        blur: "focusout"
    },
    function(a, b) {
        var c = 0,
        d = function(a) {
            ib.event.simulate(b, a.target, ib.event.fix(a), !0)
        };
        ib.event.special[b] = {
            setup: function() {
                0 === c++&&W.addEventListener(a, d, !0)
            },
            teardown: function() {
                0 === --c && W.removeEventListener(a, d, !0)
            }
        }
    }),
    ib.fn.extend({
        on: function(a, c, d, e, f) {
            var g, h;
            if ("object" == typeof a) {
                "string" != typeof c && (d = d || c, c = b);
                for (g in a) this.on(g, c, d, a[g], f);
                return this
            }
            if (null == d && null == e ? (e = c, d = c = b) : null == e && ("string" == typeof c ? (e = d, d = b) : (e = d, d = c, c = b)), e === !1) e = j;
            else if (!e) return this;
            return 1 === f && (h = e, e = function(a) {
                return ib().off(a),
                h.apply(this, arguments)
            },
            e.guid = h.guid || (h.guid = ib.guid++)),
            this.each(function() {
                ib.event.add(this, a, e, d, c)
            })
        },
        one: function(a, b, c, d) {
            return this.on(a, b, c, d, 1)
        },
        off: function(a, c, d) {
            var e, f;
            if (a && a.preventDefault && a.handleObj) return e = a.handleObj,
            ib(a.delegateTarget).off(e.namespace ? e.origType + "." + e.namespace: e.origType, e.selector, e.handler),
            this;
            if ("object" == typeof a) {
                for (f in a) this.off(f, c, a[f]);
                return this
            }
            return (c === !1 || "function" == typeof c) && (d = c, c = b),
            d === !1 && (d = j),
            this.each(function() {
                ib.event.remove(this, a, d, c)
            })
        },
        bind: function(a, b, c) {
            return this.on(a, null, b, c)
        },
        unbind: function(a, b) {
            return this.off(a, null, b)
        },
        delegate: function(a, b, c, d) {
            return this.on(b, a, c, d)
        },
        undelegate: function(a, b, c) {
            return 1 === arguments.length ? this.off(a, "**") : this.off(b, a || "**", c)
        },
        trigger: function(a, b) {
            return this.each(function() {
                ib.event.trigger(a, b, this)
            })
        },
        triggerHandler: function(a, b) {
            var c = this[0];
            return c ? ib.event.trigger(a, b, c, !0) : void 0
        }
    }),
    function(a, b) {
        function c(a) {
            return ob.test(a + "")
        }
        function d() {
            var a, b = [];
            return a = function(c, d) {
                return b.push(c += " ") > y.cacheLength && delete a[b.shift()],
                a[c] = d
            }
        }
        function e(a) {
            return a[N] = !0,
            a
        }
        function f(a) {
            var b = F.createElement("div");
            try {
                return a(b)
            } catch(c) {
                return ! 1
            } finally {
                b = null
            }
        }
        function g(a, b, c, d) {
            var e, f, g, h, i, j, k, n, o, p;
            if ((b ? b.ownerDocument || b: O) !== F && E(b), b = b || F, c = c || [], !a || "string" != typeof a) return c;
            if (1 !== (h = b.nodeType) && 9 !== h) return [];
            if (!H && !d) {
                if (e = pb.exec(a)) if (g = e[1]) {
                    if (9 === h) {
                        if (f = b.getElementById(g), !f || !f.parentNode) return c;
                        if (f.id === g) return c.push(f),
                        c
                    } else if (b.ownerDocument && (f = b.ownerDocument.getElementById(g)) && L(b, f) && f.id === g) return c.push(f),
                    c
                } else {
                    if (e[2]) return Z.apply(c, $.call(b.getElementsByTagName(a), 0)),
                    c;
                    if ((g = e[3]) && P.getByClassName && b.getElementsByClassName) return Z.apply(c, $.call(b.getElementsByClassName(g), 0)),
                    c
                }
                if (P.qsa && !I.test(a)) {
                    if (k = !0, n = N, o = b, p = 9 === h && a, 1 === h && "object" !== b.nodeName.toLowerCase()) {
                        for (j = l(a), (k = b.getAttribute("id")) ? n = k.replace(sb, "\\$&") : b.setAttribute("id", n), n = "[id='" + n + "'] ", i = j.length; i--;) j[i] = n + m(j[i]);
                        o = nb.test(a) && b.parentNode || b,
                        p = j.join(",")
                    }
                    if (p) try {
                        return Z.apply(c, $.call(o.querySelectorAll(p), 0)),
                        c
                    } catch(q) {} finally {
                        k || b.removeAttribute("id")
                    }
                }
            }
            return u(a.replace(gb, "$1"), b, c, d)
        }
        function h(a, b) {
            var c = b && a,
            d = c && (~b.sourceIndex || W) - (~a.sourceIndex || W);
            if (d) return d;
            if (c) for (; c = c.nextSibling;) if (c === b) return - 1;
            return a ? 1 : -1
        }
        function i(a) {
            return function(b) {
                var c = b.nodeName.toLowerCase();
                return "input" === c && b.type === a
            }
        }
        function j(a) {
            return function(b) {
                var c = b.nodeName.toLowerCase();
                return ("input" === c || "button" === c) && b.type === a
            }
        }
        function k(a) {
            return e(function(b) {
                return b = +b,
                e(function(c, d) {
                    for (var e, f = a([], c.length, b), g = f.length; g--;) c[e = f[g]] && (c[e] = !(d[e] = c[e]))
                })
            })
        }
        function l(a, b) {
            var c, d, e, f, h, i, j, k = T[a + " "];
            if (k) return b ? 0 : k.slice(0);
            for (h = a, i = [], j = y.preFilter; h;) { (!c || (d = hb.exec(h))) && (d && (h = h.slice(d[0].length) || h), i.push(e = [])),
                c = !1,
                (d = jb.exec(h)) && (c = d.shift(), e.push({
                    value: c,
                    type: d[0].replace(gb, " ")
                }), h = h.slice(c.length));
                for (f in y.filter) ! (d = mb[f].exec(h)) || j[f] && !(d = j[f](d)) || (c = d.shift(), e.push({
                    value: c,
                    type: f,
                    matches: d
                }), h = h.slice(c.length));
                if (!c) break
            }
            return b ? h.length: h ? g.error(a) : T(a, i).slice(0)
        }
        function m(a) {
            for (var b = 0,
            c = a.length,
            d = ""; c > b; b++) d += a[b].value;
            return d
        }
        function n(a, b, c) {
            var d = b.dir,
            e = c && "parentNode" === d,
            f = R++;
            return b.first ?
            function(b, c, f) {
                for (; b = b[d];) if (1 === b.nodeType || e) return a(b, c, f)
            }: function(b, c, g) {
                var h, i, j, k = Q + " " + f;
                if (g) {
                    for (; b = b[d];) if ((1 === b.nodeType || e) && a(b, c, g)) return ! 0
                } else for (; b = b[d];) if (1 === b.nodeType || e) if (j = b[N] || (b[N] = {}), (i = j[d]) && i[0] === k) {
                    if ((h = i[1]) === !0 || h === x) return h === !0
                } else if (i = j[d] = [k], i[1] = a(b, c, g) || x, i[1] === !0) return ! 0
            }
        }
        function o(a) {
            return a.length > 1 ?
            function(b, c, d) {
                for (var e = a.length; e--;) if (!a[e](b, c, d)) return ! 1;
                return ! 0
            }: a[0]
        }
        function p(a, b, c, d, e) {
            for (var f, g = [], h = 0, i = a.length, j = null != b; i > h; h++)(f = a[h]) && (!c || c(f, d, e)) && (g.push(f), j && b.push(h));
            return g
        }
        function q(a, b, c, d, f, g) {
            return d && !d[N] && (d = q(d)),
            f && !f[N] && (f = q(f, g)),
            e(function(e, g, h, i) {
                var j, k, l, m = [],
                n = [],
                o = g.length,
                q = e || t(b || "*", h.nodeType ? [h] : h, []),
                r = !a || !e && b ? q: p(q, m, a, h, i),
                s = c ? f || (e ? a: o || d) ? [] : g: r;
                if (c && c(r, s, h, i), d) for (j = p(s, n), d(j, [], h, i), k = j.length; k--;)(l = j[k]) && (s[n[k]] = !(r[n[k]] = l));
                if (e) {
                    if (f || a) {
                        if (f) {
                            for (j = [], k = s.length; k--;)(l = s[k]) && j.push(r[k] = l);
                            f(null, s = [], j, i)
                        }
                        for (k = s.length; k--;)(l = s[k]) && (j = f ? _.call(e, l) : m[k]) > -1 && (e[j] = !(g[j] = l))
                    }
                } else s = p(s === g ? s.splice(o, s.length) : s),
                f ? f(null, g, s, i) : Z.apply(g, s)
            })
        }
        function r(a) {
            for (var b, c, d, e = a.length,
            f = y.relative[a[0].type], g = f || y.relative[" "], h = f ? 1 : 0, i = n(function(a) {
                return a === b
            },
            g, !0), j = n(function(a) {
                return _.call(b, a) > -1
            },
            g, !0), k = [function(a, c, d) {
                return ! f && (d || c !== D) || ((b = c).nodeType ? i(a, c, d) : j(a, c, d))
            }]; e > h; h++) if (c = y.relative[a[h].type]) k = [n(o(k), c)];
            else {
                if (c = y.filter[a[h].type].apply(null, a[h].matches), c[N]) {
                    for (d = ++h; e > d && !y.relative[a[d].type]; d++);
                    return q(h > 1 && o(k), h > 1 && m(a.slice(0, h - 1)).replace(gb, "$1"), c, d > h && r(a.slice(h, d)), e > d && r(a = a.slice(d)), e > d && m(a))
                }
                k.push(c)
            }
            return o(k)
        }
        function s(a, b) {
            var c = 0,
            d = b.length > 0,
            f = a.length > 0,
            h = function(e, h, i, j, k) {
                var l, m, n, o = [],
                q = 0,
                r = "0",
                s = e && [],
                t = null != k,
                u = D,
                v = e || f && y.find.TAG("*", k && h.parentNode || h),
                w = Q += null == u ? 1 : Math.random() || .1;
                for (t && (D = h !== F && h, x = c); null != (l = v[r]); r++) {
                    if (f && l) {
                        for (m = 0; n = a[m++];) if (n(l, h, i)) {
                            j.push(l);
                            break
                        }
                        t && (Q = w, x = ++c)
                    }
                    d && ((l = !n && l) && q--, e && s.push(l))
                }
                if (q += r, d && r !== q) {
                    for (m = 0; n = b[m++];) n(s, o, h, i);
                    if (e) {
                        if (q > 0) for (; r--;) s[r] || o[r] || (o[r] = Y.call(j));
                        o = p(o)
                    }
                    Z.apply(j, o),
                    t && !e && o.length > 0 && q + b.length > 1 && g.uniqueSort(j)
                }
                return t && (Q = w, D = u),
                s
            };
            return d ? e(h) : h
        }
        function t(a, b, c) {
            for (var d = 0,
            e = b.length; e > d; d++) g(a, b[d], c);
            return c
        }
        function u(a, b, c, d) {
            var e, f, g, h, i, j = l(a);
            if (!d && 1 === j.length) {
                if (f = j[0] = j[0].slice(0), f.length > 2 && "ID" === (g = f[0]).type && 9 === b.nodeType && !H && y.relative[f[1].type]) {
                    if (b = y.find.ID(g.matches[0].replace(ub, vb), b)[0], !b) return c;
                    a = a.slice(f.shift().value.length)
                }
                for (e = mb.needsContext.test(a) ? 0 : f.length; e--&&(g = f[e], !y.relative[h = g.type]);) if ((i = y.find[h]) && (d = i(g.matches[0].replace(ub, vb), nb.test(f[0].type) && b.parentNode || b))) {
                    if (f.splice(e, 1), a = d.length && m(f), !a) return Z.apply(c, $.call(d, 0)),
                    c;
                    break
                }
            }
            return B(a, j)(d, b, H, c, nb.test(a)),
            c
        }
        function v() {}
        var w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N = "sizzle" + -new Date,
        O = a.document,
        P = {},
        Q = 0,
        R = 0,
        S = d(),
        T = d(),
        U = d(),
        V = typeof b,
        W = 1 << 31,
        X = [],
        Y = X.pop,
        Z = X.push,
        $ = X.slice,
        _ = X.indexOf ||
        function(a) {
            for (var b = 0,
            c = this.length; c > b; b++) if (this[b] === a) return b;
            return - 1
        },
        ab = "[\\x20\\t\\r\\n\\f]",
        bb = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",
        cb = bb.replace("w", "w#"),
        db = "([*^$|!~]?=)",
        eb = "\\[" + ab + "*(" + bb + ")" + ab + "*(?:" + db + ab + "*(?:(['\"])((?:\\\\.|[^\\\\])*?)\\3|(" + cb + ")|)|)" + ab + "*\\]",
        fb = ":(" + bb + ")(?:\\(((['\"])((?:\\\\.|[^\\\\])*?)\\3|((?:\\\\.|[^\\\\()[\\]]|" + eb.replace(3, 8) + ")*)|.*)\\)|)",
        gb = new RegExp("^" + ab + "+|((?:^|[^\\\\])(?:\\\\.)*)" + ab + "+$", "g"),
        hb = new RegExp("^" + ab + "*," + ab + "*"),
        jb = new RegExp("^" + ab + "*([\\x20\\t\\r\\n\\f>+~])" + ab + "*"),
        kb = new RegExp(fb),
        lb = new RegExp("^" + cb + "$"),
        mb = {
            ID: new RegExp("^#(" + bb + ")"),
            CLASS: new RegExp("^\\.(" + bb + ")"),
            NAME: new RegExp("^\\[name=['\"]?(" + bb + ")['\"]?\\]"),
            TAG: new RegExp("^(" + bb.replace("w", "w*") + ")"),
            ATTR: new RegExp("^" + eb),
            PSEUDO: new RegExp("^" + fb),
            CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + ab + "*(even|odd|(([+-]|)(\\d*)n|)" + ab + "*(?:([+-]|)" + ab + "*(\\d+)|))" + ab + "*\\)|)", "i"),
            needsContext: new RegExp("^" + ab + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + ab + "*((?:-\\d)?\\d*)" + ab + "*\\)|)(?=[^-]|$)", "i")
        },
        nb = /[\x20\t\r\n\f]*[+~]/,
        ob = /^[^{]+\{\s*\[native code/,
        pb = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,
        qb = /^(?:input|select|textarea|button)$/i,
        rb = /^h\d$/i,
        sb = /'|\\/g,
        tb = /\=[\x20\t\r\n\f]*([^'"\]]*)[\x20\t\r\n\f]*\]/g,
        ub = /\\([\da-fA-F]{1,6}[\x20\t\r\n\f]?|.)/g,
        vb = function(a, b) {
            var c = "0x" + b - 65536;
            return c !== c ? b: 0 > c ? String.fromCharCode(c + 65536) : String.fromCharCode(c >> 10 | 55296, 1023 & c | 56320)
        };
        try {
            $.call(O.documentElement.childNodes, 0)[0].nodeType
        } catch(wb) {
            $ = function(a) {
                for (var b, c = []; b = this[a++];) c.push(b);
                return c
            }
        }
        A = g.isXML = function(a) {
            var b = a && (a.ownerDocument || a).documentElement;
            return b ? "HTML" !== b.nodeName: !1
        },
        E = g.setDocument = function(a) {
            var d = a ? a.ownerDocument || a: O;
            return d !== F && 9 === d.nodeType && d.documentElement ? (F = d, G = d.documentElement, H = A(d), P.tagNameNoComments = f(function(a) {
                return a.appendChild(d.createComment("")),
                !a.getElementsByTagName("*").length
            }), P.attributes = f(function(a) {
                a.innerHTML = "<select></select>";
                var b = typeof a.lastChild.getAttribute("multiple");
                return "boolean" !== b && "string" !== b
            }), P.getByClassName = f(function(a) {
                return a.innerHTML = "<div class='hidden e'></div><div class='hidden'></div>",
                a.getElementsByClassName && a.getElementsByClassName("e").length ? (a.lastChild.className = "e", 2 === a.getElementsByClassName("e").length) : !1
            }), P.getByName = f(function(a) {
                a.id = N + 0,
                a.innerHTML = "<a name='" + N + "'></a><div name='" + N + "'></div>",
                G.insertBefore(a, G.firstChild);
                var b = d.getElementsByName && d.getElementsByName(N).length === 2 + d.getElementsByName(N + 0).length;
                return P.getIdNotName = !d.getElementById(N),
                G.removeChild(a),
                b
            }), y.attrHandle = f(function(a) {
                return a.innerHTML = "<a href='#'></a>",
                a.firstChild && typeof a.firstChild.getAttribute !== V && "#" === a.firstChild.getAttribute("href")
            }) ? {}: {
                href: function(a) {
                    return a.getAttribute("href", 2)
                },
                type: function(a) {
                    return a.getAttribute("type")
                }
            },
            P.getIdNotName ? (y.find.ID = function(a, b) {
                if (typeof b.getElementById !== V && !H) {
                    var c = b.getElementById(a);
                    return c && c.parentNode ? [c] : []
                }
            },
            y.filter.ID = function(a) {
                var b = a.replace(ub, vb);
                return function(a) {
                    return a.getAttribute("id") === b
                }
            }) : (y.find.ID = function(a, c) {
                if (typeof c.getElementById !== V && !H) {
                    var d = c.getElementById(a);
                    return d ? d.id === a || typeof d.getAttributeNode !== V && d.getAttributeNode("id").value === a ? [d] : b: []
                }
            },
            y.filter.ID = function(a) {
                var b = a.replace(ub, vb);
                return function(a) {
                    var c = typeof a.getAttributeNode !== V && a.getAttributeNode("id");
                    return c && c.value === b
                }
            }), y.find.TAG = P.tagNameNoComments ?
            function(a, b) {
                return typeof b.getElementsByTagName !== V ? b.getElementsByTagName(a) : void 0
            }: function(a, b) {
                var c, d = [],
                e = 0,
                f = b.getElementsByTagName(a);
                if ("*" === a) {
                    for (; c = f[e++];) 1 === c.nodeType && d.push(c);
                    return d
                }
                return f
            },
            y.find.NAME = P.getByName &&
            function(a, b) {
                return typeof b.getElementsByName !== V ? b.getElementsByName(name) : void 0
            },
            y.find.CLASS = P.getByClassName &&
            function(a, b) {
                return typeof b.getElementsByClassName === V || H ? void 0 : b.getElementsByClassName(a)
            },
            J = [], I = [":focus"], (P.qsa = c(d.querySelectorAll)) && (f(function(a) {
                a.innerHTML = "<select><option selected=''></option></select>",
                a.querySelectorAll("[selected]").length || I.push("\\[" + ab + "*(?:checked|disabled|ismap|multiple|readonly|selected|value)"),
                a.querySelectorAll(":checked").length || I.push(":checked")
            }), f(function(a) {
                a.innerHTML = "<input type='hidden' i=''/>",
                a.querySelectorAll("[i^='']").length && I.push("[*^$]=" + ab + "*(?:\"\"|'')"),
                a.querySelectorAll(":enabled").length || I.push(":enabled", ":disabled"),
                a.querySelectorAll("*,:x"),
                I.push(",.*:")
            })), (P.matchesSelector = c(K = G.matchesSelector || G.mozMatchesSelector || G.webkitMatchesSelector || G.oMatchesSelector || G.msMatchesSelector)) && f(function(a) {
                P.disconnectedMatch = K.call(a, "div"),
                K.call(a, "[s!='']:x"),
                J.push("!=", fb)
            }), I = new RegExp(I.join("|")), J = new RegExp(J.join("|")), L = c(G.contains) || G.compareDocumentPosition ?
            function(a, b) {
                var c = 9 === a.nodeType ? a.documentElement: a,
                d = b && b.parentNode;
                return a === d || !(!d || 1 !== d.nodeType || !(c.contains ? c.contains(d) : a.compareDocumentPosition && 16 & a.compareDocumentPosition(d)))
            }: function(a, b) {
                if (b) for (; b = b.parentNode;) if (b === a) return ! 0;
                return ! 1
            },
            M = G.compareDocumentPosition ?
            function(a, b) {
                var c;
                return a === b ? (C = !0, 0) : (c = b.compareDocumentPosition && a.compareDocumentPosition && a.compareDocumentPosition(b)) ? 1 & c || a.parentNode && 11 === a.parentNode.nodeType ? a === d || L(O, a) ? -1 : b === d || L(O, b) ? 1 : 0 : 4 & c ? -1 : 1 : a.compareDocumentPosition ? -1 : 1
            }: function(a, b) {
                var c, e = 0,
                f = a.parentNode,
                g = b.parentNode,
                i = [a],
                j = [b];
                if (a === b) return C = !0,
                0;
                if (!f || !g) return a === d ? -1 : b === d ? 1 : f ? -1 : g ? 1 : 0;
                if (f === g) return h(a, b);
                for (c = a; c = c.parentNode;) i.unshift(c);
                for (c = b; c = c.parentNode;) j.unshift(c);
                for (; i[e] === j[e];) e++;
                return e ? h(i[e], j[e]) : i[e] === O ? -1 : j[e] === O ? 1 : 0
            },
            C = !1, [0, 0].sort(M), P.detectDuplicates = C, F) : F
        },
        g.matches = function(a, b) {
            return g(a, null, null, b)
        },
        g.matchesSelector = function(a, b) {
            if ((a.ownerDocument || a) !== F && E(a), b = b.replace(tb, "='$1']"), !(!P.matchesSelector || H || J && J.test(b) || I.test(b))) try {
                var c = K.call(a, b);
                if (c || P.disconnectedMatch || a.document && 11 !== a.document.nodeType) return c
            } catch(d) {}
            return g(b, F, null, [a]).length > 0
        },
        g.contains = function(a, b) {
            return (a.ownerDocument || a) !== F && E(a),
            L(a, b)
        },
        g.attr = function(a, b) {
            var c;
            return (a.ownerDocument || a) !== F && E(a),
            H || (b = b.toLowerCase()),
            (c = y.attrHandle[b]) ? c(a) : H || P.attributes ? a.getAttribute(b) : ((c = a.getAttributeNode(b)) || a.getAttribute(b)) && a[b] === !0 ? b: c && c.specified ? c.value: null
        },
        g.error = function(a) {
            throw new Error("Syntax error, unrecognized expression: " + a)
        },
        g.uniqueSort = function(a) {
            var b, c = [],
            d = 1,
            e = 0;
            if (C = !P.detectDuplicates, a.sort(M), C) {
                for (; b = a[d]; d++) b === a[d - 1] && (e = c.push(d));
                for (; e--;) a.splice(c[e], 1)
            }
            return a
        },
        z = g.getText = function(a) {
            var b, c = "",
            d = 0,
            e = a.nodeType;
            if (e) {
                if (1 === e || 9 === e || 11 === e) {
                    if ("string" == typeof a.textContent) return a.textContent;
                    for (a = a.firstChild; a; a = a.nextSibling) c += z(a)
                } else if (3 === e || 4 === e) return a.nodeValue
            } else for (; b = a[d]; d++) c += z(b);
            return c
        },
        y = g.selectors = {
            cacheLength: 50,
            createPseudo: e,
            match: mb,
            find: {},
            relative: {
                ">": {
                    dir: "parentNode",
                    first: !0
                },
                " ": {
                    dir: "parentNode"
                },
                "+": {
                    dir: "previousSibling",
                    first: !0
                },
                "~": {
                    dir: "previousSibling"
                }
            },
            preFilter: {
                ATTR: function(a) {
                    return a[1] = a[1].replace(ub, vb),
                    a[3] = (a[4] || a[5] || "").replace(ub, vb),
                    "~=" === a[2] && (a[3] = " " + a[3] + " "),
                    a.slice(0, 4)
                },
                CHILD: function(a) {
                    return a[1] = a[1].toLowerCase(),
                    "nth" === a[1].slice(0, 3) ? (a[3] || g.error(a[0]), a[4] = +(a[4] ? a[5] + (a[6] || 1) : 2 * ("even" === a[3] || "odd" === a[3])), a[5] = +(a[7] + a[8] || "odd" === a[3])) : a[3] && g.error(a[0]),
                    a
                },
                PSEUDO: function(a) {
                    var b, c = !a[5] && a[2];
                    return mb.CHILD.test(a[0]) ? null: (a[4] ? a[2] = a[4] : c && kb.test(c) && (b = l(c, !0)) && (b = c.indexOf(")", c.length - b) - c.length) && (a[0] = a[0].slice(0, b), a[2] = c.slice(0, b)), a.slice(0, 3))
                }
            },
            filter: {
                TAG: function(a) {
                    return "*" === a ?
                    function() {
                        return ! 0
                    }: (a = a.replace(ub, vb).toLowerCase(),
                    function(b) {
                        return b.nodeName && b.nodeName.toLowerCase() === a
                    })
                },
                CLASS: function(a) {
                    var b = S[a + " "];
                    return b || (b = new RegExp("(^|" + ab + ")" + a + "(" + ab + "|$)")) && S(a,
                    function(a) {
                        return b.test(a.className || typeof a.getAttribute !== V && a.getAttribute("class") || "")
                    })
                },
                ATTR: function(a, b, c) {
                    return function(d) {
                        var e = g.attr(d, a);
                        return null == e ? "!=" === b: b ? (e += "", "=" === b ? e === c: "!=" === b ? e !== c: "^=" === b ? c && 0 === e.indexOf(c) : "*=" === b ? c && e.indexOf(c) > -1 : "$=" === b ? c && e.slice( - c.length) === c: "~=" === b ? (" " + e + " ").indexOf(c) > -1 : "|=" === b ? e === c || e.slice(0, c.length + 1) === c + "-": !1) : !0
                    }
                },
                CHILD: function(a, b, c, d, e) {
                    var f = "nth" !== a.slice(0, 3),
                    g = "last" !== a.slice( - 4),
                    h = "of-type" === b;
                    return 1 === d && 0 === e ?
                    function(a) {
                        return !! a.parentNode
                    }: function(b, c, i) {
                        var j, k, l, m, n, o, p = f !== g ? "nextSibling": "previousSibling",
                        q = b.parentNode,
                        r = h && b.nodeName.toLowerCase(),
                        s = !i && !h;
                        if (q) {
                            if (f) {
                                for (; p;) {
                                    for (l = b; l = l[p];) if (h ? l.nodeName.toLowerCase() === r: 1 === l.nodeType) return ! 1;
                                    o = p = "only" === a && !o && "nextSibling"
                                }
                                return ! 0
                            }
                            if (o = [g ? q.firstChild: q.lastChild], g && s) {
                                for (k = q[N] || (q[N] = {}), j = k[a] || [], n = j[0] === Q && j[1], m = j[0] === Q && j[2], l = n && q.childNodes[n]; l = ++n && l && l[p] || (m = n = 0) || o.pop();) if (1 === l.nodeType && ++m && l === b) {
                                    k[a] = [Q, n, m];
                                    break
                                }
                            } else if (s && (j = (b[N] || (b[N] = {}))[a]) && j[0] === Q) m = j[1];
                            else for (; (l = ++n && l && l[p] || (m = n = 0) || o.pop()) && ((h ? l.nodeName.toLowerCase() !== r: 1 !== l.nodeType) || !++m || (s && ((l[N] || (l[N] = {}))[a] = [Q, m]), l !== b)););
                            return m -= e,
                            m === d || m % d === 0 && m / d >= 0
                        }
                    }
                },
                PSEUDO: function(a, b) {
                    var c, d = y.pseudos[a] || y.setFilters[a.toLowerCase()] || g.error("unsupported pseudo: " + a);
                    return d[N] ? d(b) : d.length > 1 ? (c = [a, a, "", b], y.setFilters.hasOwnProperty(a.toLowerCase()) ? e(function(a, c) {
                        for (var e, f = d(a, b), g = f.length; g--;) e = _.call(a, f[g]),
                        a[e] = !(c[e] = f[g])
                    }) : function(a) {
                        return d(a, 0, c)
                    }) : d
                }
            },
            pseudos: {
                not: e(function(a) {
                    var b = [],
                    c = [],
                    d = B(a.replace(gb, "$1"));
                    return d[N] ? e(function(a, b, c, e) {
                        for (var f, g = d(a, null, e, []), h = a.length; h--;)(f = g[h]) && (a[h] = !(b[h] = f))
                    }) : function(a, e, f) {
                        return b[0] = a,
                        d(b, null, f, c),
                        !c.pop()
                    }
                }),
                has: e(function(a) {
                    return function(b) {
                        return g(a, b).length > 0
                    }
                }),
                contains: e(function(a) {
                    return function(b) {
                        return (b.textContent || b.innerText || z(b)).indexOf(a) > -1
                    }
                }),
                lang: e(function(a) {
                    return lb.test(a || "") || g.error("unsupported lang: " + a),
                    a = a.replace(ub, vb).toLowerCase(),
                    function(b) {
                        var c;
                        do
                        if (c = H ? b.getAttribute("xml:lang") || b.getAttribute("lang") : b.lang) return c = c.toLowerCase(),
                        c === a || 0 === c.indexOf(a + "-");
                        while ((b = b.parentNode) && 1 === b.nodeType);
                        return ! 1
                    }
                }),
                target: function(b) {
                    var c = a.location && a.location.hash;
                    return c && c.slice(1) === b.id
                },
                root: function(a) {
                    return a === G
                },
                focus: function(a) {
                    return a === F.activeElement && (!F.hasFocus || F.hasFocus()) && !!(a.type || a.href || ~a.tabIndex)
                },
                enabled: function(a) {
                    return a.disabled === !1
                },
                disabled: function(a) {
                    return a.disabled === !0
                },
                checked: function(a) {
                    var b = a.nodeName.toLowerCase();
                    return "input" === b && !!a.checked || "option" === b && !!a.selected
                },
                selected: function(a) {
                    return a.parentNode && a.parentNode.selectedIndex,
                    a.selected === !0
                },
                empty: function(a) {
                    for (a = a.firstChild; a; a = a.nextSibling) if (a.nodeName > "@" || 3 === a.nodeType || 4 === a.nodeType) return ! 1;
                    return ! 0
                },
                parent: function(a) {
                    return ! y.pseudos.empty(a)
                },
                header: function(a) {
                    return rb.test(a.nodeName)
                },
                input: function(a) {
                    return qb.test(a.nodeName)
                },
                button: function(a) {
                    var b = a.nodeName.toLowerCase();
                    return "input" === b && "button" === a.type || "button" === b
                },
                text: function(a) {
                    var b;
                    return "input" === a.nodeName.toLowerCase() && "text" === a.type && (null == (b = a.getAttribute("type")) || b.toLowerCase() === a.type)
                },
                first: k(function() {
                    return [0]
                }),
                last: k(function(a, b) {
                    return [b - 1]
                }),
                eq: k(function(a, b, c) {
                    return [0 > c ? c + b: c]
                }),
                even: k(function(a, b) {
                    for (var c = 0; b > c; c += 2) a.push(c);
                    return a
                }),
                odd: k(function(a, b) {
                    for (var c = 1; b > c; c += 2) a.push(c);
                    return a
                }),
                lt: k(function(a, b, c) {
                    for (var d = 0 > c ? c + b: c; --d >= 0;) a.push(d);
                    return a
                }),
                gt: k(function(a, b, c) {
                    for (var d = 0 > c ? c + b: c; ++d < b;) a.push(d);
                    return a
                })
            }
        };
        for (w in {
            radio: !0,
            checkbox: !0,
            file: !0,
            password: !0,
            image: !0
        }) y.pseudos[w] = i(w);
        for (w in {
            submit: !0,
            reset: !0
        }) y.pseudos[w] = j(w);
        B = g.compile = function(a, b) {
            var c, d = [],
            e = [],
            f = U[a + " "];
            if (!f) {
                for (b || (b = l(a)), c = b.length; c--;) f = r(b[c]),
                f[N] ? d.push(f) : e.push(f);
                f = U(a, s(e, d))
            }
            return f
        },
        y.pseudos.nth = y.pseudos.eq,
        y.filters = v.prototype = y.pseudos,
        y.setFilters = new v,
        E(),
        g.attr = ib.attr,
        ib.find = g,
        ib.expr = g.selectors,
        ib.expr[":"] = ib.expr.pseudos,
        ib.unique = g.uniqueSort,
        ib.text = g.getText,
        ib.isXMLDoc = g.isXML,
        ib.contains = g.contains
    } (a);
    var Pb = /Until$/,
    Qb = /^(?:parents|prev(?:Until|All))/,
    Rb = /^.[^:#\[\.,]*$/,
    Sb = ib.expr.match.needsContext,
    Tb = {
        children: !0,
        contents: !0,
        next: !0,
        prev: !0
    };
    ib.fn.extend({
        find: function(a) {
            var b, c, d, e = this.length;
            if ("string" != typeof a) return d = this,
            this.pushStack(ib(a).filter(function() {
                for (b = 0; e > b; b++) if (ib.contains(d[b], this)) return ! 0
            }));
            for (c = [], b = 0; e > b; b++) ib.find(a, this[b], c);
            return c = this.pushStack(e > 1 ? ib.unique(c) : c),
            c.selector = (this.selector ? this.selector + " ": "") + a,
            c
        },
        has: function(a) {
            var b, c = ib(a, this),
            d = c.length;
            return this.filter(function() {
                for (b = 0; d > b; b++) if (ib.contains(this, c[b])) return ! 0
            })
        },
        not: function(a) {
            return this.pushStack(l(this, a, !1))
        },
        filter: function(a) {
            return this.pushStack(l(this, a, !0))
        },
        is: function(a) {
            return !! a && ("string" == typeof a ? Sb.test(a) ? ib(a, this.context).index(this[0]) >= 0 : ib.filter(a, this).length > 0 : this.filter(a).length > 0)
        },
        closest: function(a, b) {
            for (var c, d = 0,
            e = this.length,
            f = [], g = Sb.test(a) || "string" != typeof a ? ib(a, b || this.context) : 0; e > d; d++) for (c = this[d]; c && c.ownerDocument && c !== b && 11 !== c.nodeType;) {
                if (g ? g.index(c) > -1 : ib.find.matchesSelector(c, a)) {
                    f.push(c);
                    break
                }
                c = c.parentNode
            }
            return this.pushStack(f.length > 1 ? ib.unique(f) : f)
        },
        index: function(a) {
            return a ? "string" == typeof a ? ib.inArray(this[0], ib(a)) : ib.inArray(a.jquery ? a[0] : a, this) : this[0] && this[0].parentNode ? this.first().prevAll().length: -1
        },
        add: function(a, b) {
            var c = "string" == typeof a ? ib(a, b) : ib.makeArray(a && a.nodeType ? [a] : a),
            d = ib.merge(this.get(), c);
            return this.pushStack(ib.unique(d))
        },
        addBack: function(a) {
            return this.add(null == a ? this.prevObject: this.prevObject.filter(a))
        }
    }),
    ib.fn.andSelf = ib.fn.addBack,
    ib.each({
        parent: function(a) {
            var b = a.parentNode;
            return b && 11 !== b.nodeType ? b: null
        },
        parents: function(a) {
            return ib.dir(a, "parentNode")
        },
        parentsUntil: function(a, b, c) {
            return ib.dir(a, "parentNode", c)
        },
        next: function(a) {
            return k(a, "nextSibling")
        },
        prev: function(a) {
            return k(a, "previousSibling")
        },
        nextAll: function(a) {
            return ib.dir(a, "nextSibling")
        },
        prevAll: function(a) {
            return ib.dir(a, "previousSibling")
        },
        nextUntil: function(a, b, c) {
            return ib.dir(a, "nextSibling", c)
        },
        prevUntil: function(a, b, c) {
            return ib.dir(a, "previousSibling", c)
        },
        siblings: function(a) {
            return ib.sibling((a.parentNode || {}).firstChild, a)
        },
        children: function(a) {
            return ib.sibling(a.firstChild)
        },
        contents: function(a) {
            return ib.nodeName(a, "iframe") ? a.contentDocument || a.contentWindow.document: ib.merge([], a.childNodes)
        }
    },
    function(a, b) {
        ib.fn[a] = function(c, d) {
            var e = ib.map(this, b, c);
            return Pb.test(a) || (d = c),
            d && "string" == typeof d && (e = ib.filter(d, e)),
            e = this.length > 1 && !Tb[a] ? ib.unique(e) : e,
            this.length > 1 && Qb.test(a) && (e = e.reverse()),
            this.pushStack(e)
        }
    }),
    ib.extend({
        filter: function(a, b, c) {
            return c && (a = ":not(" + a + ")"),
            1 === b.length ? ib.find.matchesSelector(b[0], a) ? [b[0]] : [] : ib.find.matches(a, b)
        },
        dir: function(a, c, d) {
            for (var e = [], f = a[c]; f && 9 !== f.nodeType && (d === b || 1 !== f.nodeType || !ib(f).is(d));) 1 === f.nodeType && e.push(f),
            f = f[c];
            return e
        },
        sibling: function(a, b) {
            for (var c = []; a; a = a.nextSibling) 1 === a.nodeType && a !== b && c.push(a);
            return c
        }
    });
    var Ub = "abbr|article|aside|audio|bdi|canvas|data|datalist|details|figcaption|figure|footer|header|hgroup|mark|meter|nav|output|progress|section|summary|time|video",
    Vb = / jQuery\d+="(?:null|\d+)"/g,
    Wb = new RegExp("<(?:" + Ub + ")[\\s/>]", "i"),
    Xb = /^\s+/,
    Yb = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,
    Zb = /<([\w:]+)/,
    $b = /<tbody/i,
    _b = /<|&#?\w+;/,
    ac = /<(?:script|style|link)/i,
    bc = /^(?:checkbox|radio)$/i,
    cc = /checked\s*(?:[^=]|=\s*.checked.)/i,
    dc = /^$|\/(?:java|ecma)script/i,
    ec = /^true\/(.*)/,
    fc = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g,
    gc = {
        option: [1, "<select multiple='multiple'>", "</select>"],
        legend: [1, "<fieldset>", "</fieldset>"],
        area: [1, "<map>", "</map>"],
        param: [1, "<object>", "</object>"],
        thead: [1, "<table>", "</table>"],
        tr: [2, "<table><tbody>", "</tbody></table>"],
        col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
        td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
        _default: ib.support.htmlSerialize ? [0, "", ""] : [1, "X<div>", "</div>"]
    },
    hc = m(W),
    ic = hc.appendChild(W.createElement("div"));
    gc.optgroup = gc.option,
    gc.tbody = gc.tfoot = gc.colgroup = gc.caption = gc.thead,
    gc.th = gc.td,
    ib.fn.extend({
        text: function(a) {
            return ib.access(this,
            function(a) {
                return a === b ? ib.text(this) : this.empty().append((this[0] && this[0].ownerDocument || W).createTextNode(a))
            },
            null, a, arguments.length)
        },
        wrapAll: function(a) {
            if (ib.isFunction(a)) return this.each(function(b) {
                ib(this).wrapAll(a.call(this, b))
            });
            if (this[0]) {
                var b = ib(a, this[0].ownerDocument).eq(0).clone(!0);
                this[0].parentNode && b.insertBefore(this[0]),
                b.map(function() {
                    for (var a = this; a.firstChild && 1 === a.firstChild.nodeType;) a = a.firstChild;
                    return a
                }).append(this)
            }
            return this
        },
        wrapInner: function(a) {
            return this.each(ib.isFunction(a) ?
            function(b) {
                ib(this).wrapInner(a.call(this, b))
            }: function() {
                var b = ib(this),
                c = b.contents();
                c.length ? c.wrapAll(a) : b.append(a)
            })
        },
        wrap: function(a) {
            var b = ib.isFunction(a);
            return this.each(function(c) {
                ib(this).wrapAll(b ? a.call(this, c) : a)
            })
        },
        unwrap: function() {
            return this.parent().each(function() {
                ib.nodeName(this, "body") || ib(this).replaceWith(this.childNodes)
            }).end()
        },
        append: function() {
            return this.domManip(arguments, !0,
            function(a) { (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) && this.appendChild(a)
            })
        },
        prepend: function() {
            return this.domManip(arguments, !0,
            function(a) { (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) && this.insertBefore(a, this.firstChild)
            })
        },
        before: function() {
            return this.domManip(arguments, !1,
            function(a) {
                this.parentNode && this.parentNode.insertBefore(a, this)
            })
        },
        after: function() {
            return this.domManip(arguments, !1,
            function(a) {
                this.parentNode && this.parentNode.insertBefore(a, this.nextSibling)
            })
        },
        remove: function(a, b) {
            for (var c, d = 0; null != (c = this[d]); d++)(!a || ib.filter(a, [c]).length > 0) && (b || 1 !== c.nodeType || ib.cleanData(t(c)), c.parentNode && (b && ib.contains(c.ownerDocument, c) && q(t(c, "script")), c.parentNode.removeChild(c)));
            return this
        },
        empty: function() {
            for (var a, b = 0; null != (a = this[b]); b++) {
                for (1 === a.nodeType && ib.cleanData(t(a, !1)); a.firstChild;) a.removeChild(a.firstChild);
                a.options && ib.nodeName(a, "select") && (a.options.length = 0)
            }
            return this
        },
        clone: function(a, b) {
            return a = null == a ? !1 : a,
            b = null == b ? a: b,
            this.map(function() {
                return ib.clone(this, a, b)
            })
        },
        html: function(a) {
            return ib.access(this,
            function(a) {
                var c = this[0] || {},
                d = 0,
                e = this.length;
                if (a === b) return 1 === c.nodeType ? c.innerHTML.replace(Vb, "") : b;
                if (! ("string" != typeof a || ac.test(a) || !ib.support.htmlSerialize && Wb.test(a) || !ib.support.leadingWhitespace && Xb.test(a) || gc[(Zb.exec(a) || ["", ""])[1].toLowerCase()])) {
                    a = a.replace(Yb, "<$1></$2>");
                    try {
                        for (; e > d; d++) c = this[d] || {},
                        1 === c.nodeType && (ib.cleanData(t(c, !1)), c.innerHTML = a);
                        c = 0
                    } catch(f) {}
                }
                c && this.empty().append(a)
            },
            null, a, arguments.length)
        },
        replaceWith: function(a) {
            var b = ib.isFunction(a);
            return b || "string" == typeof a || (a = ib(a).not(this).detach()),
            this.domManip([a], !0,
            function(a) {
                var b = this.nextSibling,
                c = this.parentNode;
                c && (ib(this).remove(), c.insertBefore(a, b))
            })
        },
        detach: function(a) {
            return this.remove(a, !0)
        },
        domManip: function(a, c, d) {
            a = bb.apply([], a);
            var e, f, g, h, i, j, k = 0,
            l = this.length,
            m = this,
            q = l - 1,
            r = a[0],
            s = ib.isFunction(r);
            if (s || !(1 >= l || "string" != typeof r || ib.support.checkClone) && cc.test(r)) return this.each(function(e) {
                var f = m.eq(e);
                s && (a[0] = r.call(this, e, c ? f.html() : b)),
                f.domManip(a, c, d)
            });
            if (l && (j = ib.buildFragment(a, this[0].ownerDocument, !1, this), e = j.firstChild, 1 === j.childNodes.length && (j = e), e)) {
                for (c = c && ib.nodeName(e, "tr"), h = ib.map(t(j, "script"), o), g = h.length; l > k; k++) f = j,
                k !== q && (f = ib.clone(f, !0, !0), g && ib.merge(h, t(f, "script"))),
                d.call(c && ib.nodeName(this[k], "table") ? n(this[k], "tbody") : this[k], f, k);
                if (g) for (i = h[h.length - 1].ownerDocument, ib.map(h, p), k = 0; g > k; k++) f = h[k],
                dc.test(f.type || "") && !ib._data(f, "globalEval") && ib.contains(i, f) && (f.src ? ib.ajax({
                    url: f.src,
                    type: "GET",
                    dataType: "script",
                    async: !1,
                    global: !1,
                    "throws": !0
                }) : ib.globalEval((f.text || f.textContent || f.innerHTML || "").replace(fc, "")));
                j = e = null
            }
            return this
        }
    }),
    ib.each({
        appendTo: "append",
        prependTo: "prepend",
        insertBefore: "before",
        insertAfter: "after",
        replaceAll: "replaceWith"
    },
    function(a, b) {
        ib.fn[a] = function(a) {
            for (var c, d = 0,
            e = [], f = ib(a), g = f.length - 1; g >= d; d++) c = d === g ? this: this.clone(!0),
            ib(f[d])[b](c),
            cb.apply(e, c.get());
            return this.pushStack(e)
        }
    }),
    ib.extend({
        clone: function(a, b, c) {
            var d, e, f, g, h, i = ib.contains(a.ownerDocument, a);
            if (ib.support.html5Clone || ib.isXMLDoc(a) || !Wb.test("<" + a.nodeName + ">") ? f = a.cloneNode(!0) : (ic.innerHTML = a.outerHTML, ic.removeChild(f = ic.firstChild)), !(ib.support.noCloneEvent && ib.support.noCloneChecked || 1 !== a.nodeType && 11 !== a.nodeType || ib.isXMLDoc(a))) for (d = t(f), h = t(a), g = 0; null != (e = h[g]); ++g) d[g] && s(e, d[g]);
            if (b) if (c) for (h = h || t(a), d = d || t(f), g = 0; null != (e = h[g]); g++) r(e, d[g]);
            else r(a, f);
            return d = t(f, "script"),
            d.length > 0 && q(d, !i && t(a, "script")),
            d = h = e = null,
            f
        },
        buildFragment: function(a, b, c, d) {
            for (var e, f, g, h, i, j, k, l = a.length,
            n = m(b), o = [], p = 0; l > p; p++) if (f = a[p], f || 0 === f) if ("object" === ib.type(f)) ib.merge(o, f.nodeType ? [f] : f);
            else if (_b.test(f)) {
                for (h = h || n.appendChild(b.createElement("div")), i = (Zb.exec(f) || ["", ""])[1].toLowerCase(), k = gc[i] || gc._default, h.innerHTML = k[1] + f.replace(Yb, "<$1></$2>") + k[2], e = k[0]; e--;) h = h.lastChild;
                if (!ib.support.leadingWhitespace && Xb.test(f) && o.push(b.createTextNode(Xb.exec(f)[0])), !ib.support.tbody) for (f = "table" !== i || $b.test(f) ? "<table>" !== k[1] || $b.test(f) ? 0 : h: h.firstChild, e = f && f.childNodes.length; e--;) ib.nodeName(j = f.childNodes[e], "tbody") && !j.childNodes.length && f.removeChild(j);
                for (ib.merge(o, h.childNodes), h.textContent = ""; h.firstChild;) h.removeChild(h.firstChild);
                h = n.lastChild
            } else o.push(b.createTextNode(f));
            for (h && n.removeChild(h), ib.support.appendChecked || ib.grep(t(o, "input"), u), p = 0; f = o[p++];) if ((!d || -1 === ib.inArray(f, d)) && (g = ib.contains(f.ownerDocument, f), h = t(n.appendChild(f), "script"), g && q(h), c)) for (e = 0; f = h[e++];) dc.test(f.type || "") && c.push(f);
            return h = null,
            n
        },
        cleanData: function(a, b) {
            for (var c, d, e, f, g = 0,
            h = ib.expando,
            i = ib.cache,
            j = ib.support.deleteExpando,
            k = ib.event.special; null != (c = a[g]); g++) if ((b || ib.acceptData(c)) && (e = c[h], f = e && i[e])) {
                if (f.events) for (d in f.events) k[d] ? ib.event.remove(c, d) : ib.removeEvent(c, d, f.handle);
                i[e] && (delete i[e], j ? delete c[h] : typeof c.removeAttribute !== V ? c.removeAttribute(h) : c[h] = null, _.push(e))
            }
        }
    });
    var jc, kc, lc, mc = /alpha\([^)]*\)/i,
    nc = /opacity\s*=\s*([^)]*)/,
    oc = /^(top|right|bottom|left)$/,
    pc = /^(none|table(?!-c[ea]).+)/,
    qc = /^margin/,
    rc = new RegExp("^(" + jb + ")(.*)$", "i"),
    sc = new RegExp("^(" + jb + ")(?!px)[a-z%]+$", "i"),
    tc = new RegExp("^([+-])=(" + jb + ")", "i"),
    uc = {
        BODY: "block"
    },
    vc = {
        position: "absolute",
        visibility: "hidden",
        display: "block"
    },
    wc = {
        letterSpacing: 0,
        fontWeight: 400
    },
    xc = ["Top", "Right", "Bottom", "Left"],
    yc = ["Webkit", "O", "Moz", "ms"];
    ib.fn.extend({
        css: function(a, c) {
            return ib.access(this,
            function(a, c, d) {
                var e, f, g = {},
                h = 0;
                if (ib.isArray(c)) {
                    for (f = kc(a), e = c.length; e > h; h++) g[c[h]] = ib.css(a, c[h], !1, f);
                    return g
                }
                return d !== b ? ib.style(a, c, d) : ib.css(a, c)
            },
            a, c, arguments.length > 1)
        },
        show: function() {
            return x(this, !0)
        },
        hide: function() {
            return x(this)
        },
        toggle: function(a) {
            var b = "boolean" == typeof a;
            return this.each(function() { (b ? a: w(this)) ? ib(this).show() : ib(this).hide()
            })
        }
    }),
    ib.extend({
        cssHooks: {
            opacity: {
                get: function(a, b) {
                    if (b) {
                        var c = lc(a, "opacity");
                        return "" === c ? "1": c
                    }
                }
            }
        },
        cssNumber: {
            columnCount: !0,
            fillOpacity: !0,
            fontWeight: !0,
            lineHeight: !0,
            opacity: !0,
            orphans: !0,
            widows: !0,
            zIndex: !0,
            zoom: !0
        },
        cssProps: {
            "float": ib.support.cssFloat ? "cssFloat": "styleFloat"
        },
        style: function(a, c, d, e) {
            if (a && 3 !== a.nodeType && 8 !== a.nodeType && a.style) {
                var f, g, h, i = ib.camelCase(c),
                j = a.style;
                if (c = ib.cssProps[i] || (ib.cssProps[i] = v(j, i)), h = ib.cssHooks[c] || ib.cssHooks[i], d === b) return h && "get" in h && (f = h.get(a, !1, e)) !== b ? f: j[c];
                if (g = typeof d, "string" === g && (f = tc.exec(d)) && (d = (f[1] + 1) * f[2] + parseFloat(ib.css(a, c)), g = "number"), !(null == d || "number" === g && isNaN(d) || ("number" !== g || ib.cssNumber[i] || (d += "px"), ib.support.clearCloneStyle || "" !== d || 0 !== c.indexOf("background") || (j[c] = "inherit"), h && "set" in h && (d = h.set(a, d, e)) === b))) try {
                    j[c] = d
                } catch(k) {}
            }
        },
        css: function(a, c, d, e) {
            var f, g, h, i = ib.camelCase(c);
            return c = ib.cssProps[i] || (ib.cssProps[i] = v(a.style, i)),
            h = ib.cssHooks[c] || ib.cssHooks[i],
            h && "get" in h && (g = h.get(a, !0, d)),
            g === b && (g = lc(a, c, e)),
            "normal" === g && c in wc && (g = wc[c]),
            "" === d || d ? (f = parseFloat(g), d === !0 || ib.isNumeric(f) ? f || 0 : g) : g
        },
        swap: function(a, b, c, d) {
            var e, f, g = {};
            for (f in b) g[f] = a.style[f],
            a.style[f] = b[f];
            e = c.apply(a, d || []);
            for (f in b) a.style[f] = g[f];
            return e
        }
    }),
    a.getComputedStyle ? (kc = function(b) {
        return a.getComputedStyle(b, null)
    },
    lc = function(a, c, d) {
        var e, f, g, h = d || kc(a),
        i = h ? h.getPropertyValue(c) || h[c] : b,
        j = a.style;
        return h && ("" !== i || ib.contains(a.ownerDocument, a) || (i = ib.style(a, c)), sc.test(i) && qc.test(c) && (e = j.width, f = j.minWidth, g = j.maxWidth, j.minWidth = j.maxWidth = j.width = i, i = h.width, j.width = e, j.minWidth = f, j.maxWidth = g)),
        i
    }) : W.documentElement.currentStyle && (kc = function(a) {
        return a.currentStyle
    },
    lc = function(a, c, d) {
        var e, f, g, h = d || kc(a),
        i = h ? h[c] : b,
        j = a.style;
        return null == i && j && j[c] && (i = j[c]),
        sc.test(i) && !oc.test(c) && (e = j.left, f = a.runtimeStyle, g = f && f.left, g && (f.left = a.currentStyle.left), j.left = "fontSize" === c ? "1em": i, i = j.pixelLeft + "px", j.left = e, g && (f.left = g)),
        "" === i ? "auto": i
    }),
    ib.each(["height", "width"],
    function(a, b) {
        ib.cssHooks[b] = {
            get: function(a, c, d) {
                return c ? 0 === a.offsetWidth && pc.test(ib.css(a, "display")) ? ib.swap(a, vc,
                function() {
                    return A(a, b, d)
                }) : A(a, b, d) : void 0
            },
            set: function(a, c, d) {
                var e = d && kc(a);
                return y(a, c, d ? z(a, b, d, ib.support.boxSizing && "border-box" === ib.css(a, "boxSizing", !1, e), e) : 0)
            }
        }
    }),
    ib.support.opacity || (ib.cssHooks.opacity = {
        get: function(a, b) {
            return nc.test((b && a.currentStyle ? a.currentStyle.filter: a.style.filter) || "") ? .01 * parseFloat(RegExp.$1) + "": b ? "1": ""
        },
        set: function(a, b) {
            var c = a.style,
            d = a.currentStyle,
            e = ib.isNumeric(b) ? "alpha(opacity=" + 100 * b + ")": "",
            f = d && d.filter || c.filter || "";
            c.zoom = 1,
            (b >= 1 || "" === b) && "" === ib.trim(f.replace(mc, "")) && c.removeAttribute && (c.removeAttribute("filter"), "" === b || d && !d.filter) || (c.filter = mc.test(f) ? f.replace(mc, e) : f + " " + e)
        }
    }),
    ib(function() {
        ib.support.reliableMarginRight || (ib.cssHooks.marginRight = {
            get: function(a, b) {
                return b ? ib.swap(a, {
                    display: "inline-block"
                },
                lc, [a, "marginRight"]) : void 0
            }
        }),
        !ib.support.pixelPosition && ib.fn.position && ib.each(["top", "left"],
        function(a, b) {
            ib.cssHooks[b] = {
                get: function(a, c) {
                    return c ? (c = lc(a, b), sc.test(c) ? ib(a).position()[b] + "px": c) : void 0
                }
            }
        })
    }),
    ib.expr && ib.expr.filters && (ib.expr.filters.hidden = function(a) {
        return a.offsetWidth <= 0 && a.offsetHeight <= 0 || !ib.support.reliableHiddenOffsets && "none" === (a.style && a.style.display || ib.css(a, "display"))
    },
    ib.expr.filters.visible = function(a) {
        return ! ib.expr.filters.hidden(a)
    }),
    ib.each({
        margin: "",
        padding: "",
        border: "Width"
    },
    function(a, b) {
        ib.cssHooks[a + b] = {
            expand: function(c) {
                for (var d = 0,
                e = {},
                f = "string" == typeof c ? c.split(" ") : [c]; 4 > d; d++) e[a + xc[d] + b] = f[d] || f[d - 2] || f[0];
                return e
            }
        },
        qc.test(a) || (ib.cssHooks[a + b].set = y)
    });
    var zc = /%20/g,
    Ac = /\[\]$/,
    Bc = /\r?\n/g,
    Cc = /^(?:submit|button|image|reset|file)$/i,
    Dc = /^(?:input|select|textarea|keygen)/i;
    ib.fn.extend({
        serialize: function() {
            return ib.param(this.serializeArray())
        },
        serializeArray: function() {
            return this.map(function() {
                var a = ib.prop(this, "elements");
                return a ? ib.makeArray(a) : this
            }).filter(function() {
                var a = this.type;
                return this.name && !ib(this).is(":disabled") && Dc.test(this.nodeName) && !Cc.test(a) && (this.checked || !bc.test(a))
            }).map(function(a, b) {
                var c = ib(this).val();
                return null == c ? null: ib.isArray(c) ? ib.map(c,
                function(a) {
                    return {
                        name: b.name,
                        value: a.replace(Bc, "\r\n")
                    }
                }) : {
                    name: b.name,
                    value: c.replace(Bc, "\r\n")
                }
            }).get()
        }
    }),
    ib.param = function(a, c) {
        var d, e = [],
        f = function(a, b) {
            b = ib.isFunction(b) ? b() : null == b ? "": b,
            e[e.length] = encodeURIComponent(a) + "=" + encodeURIComponent(b)
        };
        if (c === b && (c = ib.ajaxSettings && ib.ajaxSettings.traditional), ib.isArray(a) || a.jquery && !ib.isPlainObject(a)) ib.each(a,
        function() {
            f(this.name, this.value)
        });
        else for (d in a) D(d, a[d], c, f);
        return e.join("&").replace(zc, "+")
    },
    ib.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "),
    function(a, b) {
        ib.fn[b] = function(a, c) {
            return arguments.length > 0 ? this.on(b, null, a, c) : this.trigger(b)
        }
    }),
    ib.fn.hover = function(a, b) {
        return this.mouseenter(a).mouseleave(b || a)
    };
    var Ec, Fc, Gc = ib.now(),
    Hc = /\?/,
    Ic = /#.*$/,
    Jc = /([?&])_=[^&]*/,
    Kc = /^(.*?):[ \t]*([^\r\n]*)\r?$/gm,
    Lc = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
    Mc = /^(?:GET|HEAD)$/,
    Nc = /^\/\//,
    Oc = /^([\w.+-]+:)(?:\/\/([^\/?#:]*)(?::(\d+)|)|)/,
    Pc = ib.fn.load,
    Qc = {},
    Rc = {},
    Sc = "*/".concat("*");
    try {
        Fc = X.href
    } catch(Tc) {
        Fc = W.createElement("a"),
        Fc.href = "",
        Fc = Fc.href
    }
    Ec = Oc.exec(Fc.toLowerCase()) || [],
    ib.fn.load = function(a, c, d) {
        if ("string" != typeof a && Pc) return Pc.apply(this, arguments);
        var e, f, g, h = this,
        i = a.indexOf(" ");
        return i >= 0 && (e = a.slice(i, a.length), a = a.slice(0, i)),
        ib.isFunction(c) ? (d = c, c = b) : c && "object" == typeof c && (g = "POST"),
        h.length > 0 && ib.ajax({
            url: a,
            type: g,
            dataType: "html",
            data: c
        }).done(function(a) {
            f = arguments,
            h.html(e ? ib("<div>").append(ib.parseHTML(a)).find(e) : a)
        }).complete(d &&
        function(a, b) {
            h.each(d, f || [a.responseText, b, a])
        }),
        this
    },
    ib.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"],
    function(a, b) {
        ib.fn[b] = function(a) {
            return this.on(b, a)
        }
    }),
    ib.each(["get", "post"],
    function(a, c) {
        ib[c] = function(a, d, e, f) {
            return ib.isFunction(d) && (f = f || e, e = d, d = b),
            ib.ajax({
                url: a,
                type: c,
                dataType: f,
                data: d,
                success: e
            })
        }
    }),
    ib.extend({
        active: 0,
        lastModified: {},
        etag: {},
        ajaxSettings: {
            url: Fc,
            type: "GET",
            isLocal: Lc.test(Ec[1]),
            global: !0,
            processData: !0,
            async: !0,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            accepts: {
                "*": Sc,
                text: "text/plain",
                html: "text/html",
                xml: "application/xml, text/xml",
                json: "application/json, text/javascript"
            },
            contents: {
                xml: /xml/,
                html: /html/,
                json: /json/
            },
            responseFields: {
                xml: "responseXML",
                text: "responseText"
            },
            converters: {
                "* text": a.String,
                "text html": !0,
                "text json": ib.parseJSON,
                "text xml": ib.parseXML
            },
            flatOptions: {
                url: !0,
                context: !0
            }
        },
        ajaxSetup: function(a, b) {
            return b ? G(G(a, ib.ajaxSettings), b) : G(ib.ajaxSettings, a)
        },
        ajaxPrefilter: E(Qc),
        ajaxTransport: E(Rc),
        ajax: function(a, c) {
            function d(a, c, d, e) {
                var f, l, s, t, v, x = c;
                2 !== u && (u = 2, i && clearTimeout(i), k = b, h = e || "", w.readyState = a > 0 ? 4 : 0, d && (t = H(m, w, d)), a >= 200 && 300 > a || 304 === a ? (m.ifModified && (v = w.getResponseHeader("Last-Modified"), v && (ib.lastModified[g] = v), v = w.getResponseHeader("etag"), v && (ib.etag[g] = v)), 204 === a ? (f = !0, x = "nocontent") : 304 === a ? (f = !0, x = "notmodified") : (f = I(m, t), x = f.state, l = f.data, s = f.error, f = !s)) : (s = x, (a || !x) && (x = "error", 0 > a && (a = 0))), w.status = a, w.statusText = (c || x) + "", f ? p.resolveWith(n, [l, x, w]) : p.rejectWith(n, [w, x, s]), w.statusCode(r), r = b, j && o.trigger(f ? "ajaxSuccess": "ajaxError", [w, m, f ? l: s]), q.fireWith(n, [w, x]), j && (o.trigger("ajaxComplete", [w, m]), --ib.active || ib.event.trigger("ajaxStop")))
            }
            "object" == typeof a && (c = a, a = b),
            c = c || {};
            var e, f, g, h, i, j, k, l, m = ib.ajaxSetup({},
            c),
            n = m.context || m,
            o = m.context && (n.nodeType || n.jquery) ? ib(n) : ib.event,
            p = ib.Deferred(),
            q = ib.Callbacks("once memory"),
            r = m.statusCode || {},
            s = {},
            t = {},
            u = 0,
            v = "canceled",
            w = {
                readyState: 0,
                getResponseHeader: function(a) {
                    var b;
                    if (2 === u) {
                        if (!l) for (l = {}; b = Kc.exec(h);) l[b[1].toLowerCase()] = b[2];
                        b = l[a.toLowerCase()]
                    }
                    return null == b ? null: b
                },
                getAllResponseHeaders: function() {
                    return 2 === u ? h: null
                },
                setRequestHeader: function(a, b) {
                    var c = a.toLowerCase();
                    return u || (a = t[c] = t[c] || a, s[a] = b),
                    this
                },
                overrideMimeType: function(a) {
                    return u || (m.mimeType = a),
                    this
                },
                statusCode: function(a) {
                    var b;
                    if (a) if (2 > u) for (b in a) r[b] = [r[b], a[b]];
                    else w.always(a[w.status]);
                    return this
                },
                abort: function(a) {
                    var b = a || v;
                    return k && k.abort(b),
                    d(0, b),
                    this
                }
            };
            if (p.promise(w).complete = q.add, w.success = w.done, w.error = w.fail, m.url = ((a || m.url || Fc) + "").replace(Ic, "").replace(Nc, Ec[1] + "//"), m.type = c.method || c.type || m.method || m.type, m.dataTypes = ib.trim(m.dataType || "*").toLowerCase().match(kb) || [""], null == m.crossDomain && (e = Oc.exec(m.url.toLowerCase()), m.crossDomain = !(!e || e[1] === Ec[1] && e[2] === Ec[2] && (e[3] || ("http:" === e[1] ? 80 : 443)) == (Ec[3] || ("http:" === Ec[1] ? 80 : 443)))), m.data && m.processData && "string" != typeof m.data && (m.data = ib.param(m.data, m.traditional)), F(Qc, m, c, w), 2 === u) return w;
            j = m.global,
            j && 0 === ib.active++&&ib.event.trigger("ajaxStart"),
            m.type = m.type.toUpperCase(),
            m.hasContent = !Mc.test(m.type),
            g = m.url,
            m.hasContent || (m.data && (g = m.url += (Hc.test(g) ? "&": "?") + m.data, delete m.data), m.cache === !1 && (m.url = Jc.test(g) ? g.replace(Jc, "$1_=" + Gc++) : g + (Hc.test(g) ? "&": "?") + "_=" + Gc++)),
            m.ifModified && (ib.lastModified[g] && w.setRequestHeader("If-Modified-Since", ib.lastModified[g]), ib.etag[g] && w.setRequestHeader("If-None-Match", ib.etag[g])),
            (m.data && m.hasContent && m.contentType !== !1 || c.contentType) && w.setRequestHeader("Content-Type", m.contentType),
            w.setRequestHeader("Accept", m.dataTypes[0] && m.accepts[m.dataTypes[0]] ? m.accepts[m.dataTypes[0]] + ("*" !== m.dataTypes[0] ? ", " + Sc + "; q=0.01": "") : m.accepts["*"]);
            for (f in m.headers) w.setRequestHeader(f, m.headers[f]);
            if (m.beforeSend && (m.beforeSend.call(n, w, m) === !1 || 2 === u)) return w.abort();
            v = "abort";
            for (f in {
                success: 1,
                error: 1,
                complete: 1
            }) w[f](m[f]);
            if (k = F(Rc, m, c, w)) {
                w.readyState = 1,
                j && o.trigger("ajaxSend", [w, m]),
                m.async && m.timeout > 0 && (i = setTimeout(function() {
                    w.abort("timeout")
                },
                m.timeout));
                try {
                    u = 1,
                    k.send(s, d)
                } catch(x) {
                    if (! (2 > u)) throw x;
                    d( - 1, x)
                }
            } else d( - 1, "No Transport");
            return w
        },
        getScript: function(a, c) {
            return ib.get(a, b, c, "script")
        },
        getJSON: function(a, b, c) {
            return ib.get(a, b, c, "json")
        }
    }),
    ib.ajaxSetup({
        accepts: {
            script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
        },
        contents: {
            script: /(?:java|ecma)script/
        },
        converters: {
            "text script": function(a) {
                return ib.globalEval(a),
                a
            }
        }
    }),
    ib.ajaxPrefilter("script",
    function(a) {
        a.cache === b && (a.cache = !1),
        a.crossDomain && (a.type = "GET", a.global = !1)
    }),
    ib.ajaxTransport("script",
    function(a) {
        if (a.crossDomain) {
            var c, d = W.head || ib("head")[0] || W.documentElement;
            return {
                send: function(b, e) {
                    c = W.createElement("script"),
                    c.async = !0,
                    a.scriptCharset && (c.charset = a.scriptCharset),
                    c.src = a.url,
                    c.onload = c.onreadystatechange = function(a, b) { (b || !c.readyState || /loaded|complete/.test(c.readyState)) && (c.onload = c.onreadystatechange = null, c.parentNode && c.parentNode.removeChild(c), c = null, b || e(200, "success"))
                    },
                    d.insertBefore(c, d.firstChild)
                },
                abort: function() {
                    c && c.onload(b, !0)
                }
            }
        }
    });
    var Uc = [],
    Vc = /(=)\?(?=&|$)|\?\?/;
    ib.ajaxSetup({
        jsonp: "callback",
        jsonpCallback: function() {
            var a = Uc.pop() || ib.expando + "_" + Gc++;
            return this[a] = !0,
            a
        }
    }),
    ib.ajaxPrefilter("json jsonp",
    function(c, d, e) {
        var f, g, h, i = c.jsonp !== !1 && (Vc.test(c.url) ? "url": "string" == typeof c.data && !(c.contentType || "").indexOf("application/x-www-form-urlencoded") && Vc.test(c.data) && "data");
        return i || "jsonp" === c.dataTypes[0] ? (f = c.jsonpCallback = ib.isFunction(c.jsonpCallback) ? c.jsonpCallback() : c.jsonpCallback, i ? c[i] = c[i].replace(Vc, "$1" + f) : c.jsonp !== !1 && (c.url += (Hc.test(c.url) ? "&": "?") + c.jsonp + "=" + f), c.converters["script json"] = function() {
            return h || ib.error(f + " was not called"),
            h[0]
        },
        c.dataTypes[0] = "json", g = a[f], a[f] = function() {
            h = arguments
        },
        e.always(function() {
            a[f] = g,
            c[f] && (c.jsonpCallback = d.jsonpCallback, Uc.push(f)),
            h && ib.isFunction(g) && g(h[0]),
            h = g = b
        }), "script") : void 0
    });
    var Wc, Xc, Yc = 0,
    Zc = a.ActiveXObject &&
    function() {
        var a;
        for (a in Wc) Wc[a](b, !0)
    };
    ib.ajaxSettings.xhr = a.ActiveXObject ?
    function() {
        return ! this.isLocal && J() || K()
    }: J,
    Xc = ib.ajaxSettings.xhr(),
    ib.support.cors = !!Xc && "withCredentials" in Xc,
    Xc = ib.support.ajax = !!Xc,
    Xc && ib.ajaxTransport(function(c) {
        if (!c.crossDomain || ib.support.cors) {
            var d;
            return {
                send: function(e, f) {
                    var g, h, i = c.xhr();
                    if (c.username ? i.open(c.type, c.url, c.async, c.username, c.password) : i.open(c.type, c.url, c.async), c.xhrFields) for (h in c.xhrFields) i[h] = c.xhrFields[h];
                    c.mimeType && i.overrideMimeType && i.overrideMimeType(c.mimeType),
                    c.crossDomain || e["X-Requested-With"] || (e["X-Requested-With"] = "XMLHttpRequest");
                    try {
                        for (h in e) i.setRequestHeader(h, e[h])
                    } catch(j) {}
                    i.send(c.hasContent && c.data || null),
                    d = function(a, e) {
                        var h, j, k, l;
                        try {
                            if (d && (e || 4 === i.readyState)) if (d = b, g && (i.onreadystatechange = ib.noop, Zc && delete Wc[g]), e) 4 !== i.readyState && i.abort();
                            else {
                                l = {},
                                h = i.status,
                                j = i.getAllResponseHeaders(),
                                "string" == typeof i.responseText && (l.text = i.responseText);
                                try {
                                    k = i.statusText
                                } catch(m) {
                                    k = ""
                                }
                                h || !c.isLocal || c.crossDomain ? 1223 === h && (h = 204) : h = l.text ? 200 : 404
                            }
                        } catch(n) {
                            e || f( - 1, n)
                        }
                        l && f(h, k, l, j)
                    },
                    c.async ? 4 === i.readyState ? setTimeout(d) : (g = ++Yc, Zc && (Wc || (Wc = {},
                    ib(a).unload(Zc)), Wc[g] = d), i.onreadystatechange = d) : d()
                },
                abort: function() {
                    d && d(b, !0)
                }
            }
        }
    });
    var $c, _c, ad = /^(?:toggle|show|hide)$/,
    bd = new RegExp("^(?:([+-])=|)(" + jb + ")([a-z%]*)$", "i"),
    cd = /queueHooks$/,
    dd = [P],
    ed = {
        "*": [function(a, b) {
            var c, d, e = this.createTween(a, b),
            f = bd.exec(b),
            g = e.cur(),
            h = +g || 0,
            i = 1,
            j = 20;
            if (f) {
                if (c = +f[2], d = f[3] || (ib.cssNumber[a] ? "": "px"), "px" !== d && h) {
                    h = ib.css(e.elem, a, !0) || c || 1;
                    do i = i || ".5",
                    h /= i,
                    ib.style(e.elem, a, h + d);
                    while (i !== (i = e.cur() / g) && 1 !== i && --j)
                }
                e.unit = d,
                e.start = h,
                e.end = f[1] ? h + (f[1] + 1) * c: c
            }
            return e
        }]
    };
    ib.Animation = ib.extend(N, {
        tweener: function(a, b) {
            ib.isFunction(a) ? (b = a, a = ["*"]) : a = a.split(" ");
            for (var c, d = 0,
            e = a.length; e > d; d++) c = a[d],
            ed[c] = ed[c] || [],
            ed[c].unshift(b)
        },
        prefilter: function(a, b) {
            b ? dd.unshift(a) : dd.push(a)
        }
    }),
    ib.Tween = Q,
    Q.prototype = {
        constructor: Q,
        init: function(a, b, c, d, e, f) {
            this.elem = a,
            this.prop = c,
            this.easing = e || "swing",
            this.options = b,
            this.start = this.now = this.cur(),
            this.end = d,
            this.unit = f || (ib.cssNumber[c] ? "": "px")
        },
        cur: function() {
            var a = Q.propHooks[this.prop];
            return a && a.get ? a.get(this) : Q.propHooks._default.get(this)
        },
        run: function(a) {
            var b, c = Q.propHooks[this.prop];
            return this.pos = b = this.options.duration ? ib.easing[this.easing](a, this.options.duration * a, 0, 1, this.options.duration) : a,
            this.now = (this.end - this.start) * b + this.start,
            this.options.step && this.options.step.call(this.elem, this.now, this),
            c && c.set ? c.set(this) : Q.propHooks._default.set(this),
            this
        }
    },
    Q.prototype.init.prototype = Q.prototype,
    Q.propHooks = {
        _default: {
            get: function(a) {
                var b;
                return null == a.elem[a.prop] || a.elem.style && null != a.elem.style[a.prop] ? (b = ib.css(a.elem, a.prop, ""), b && "auto" !== b ? b: 0) : a.elem[a.prop]
            },
            set: function(a) {
                ib.fx.step[a.prop] ? ib.fx.step[a.prop](a) : a.elem.style && (null != a.elem.style[ib.cssProps[a.prop]] || ib.cssHooks[a.prop]) ? ib.style(a.elem, a.prop, a.now + a.unit) : a.elem[a.prop] = a.now
            }
        }
    },
    Q.propHooks.scrollTop = Q.propHooks.scrollLeft = {
        set: function(a) {
            a.elem.nodeType && a.elem.parentNode && (a.elem[a.prop] = a.now)
        }
    },
    ib.each(["toggle", "show", "hide"],
    function(a, b) {
        var c = ib.fn[b];
        ib.fn[b] = function(a, d, e) {
            return null == a || "boolean" == typeof a ? c.apply(this, arguments) : this.animate(R(b, !0), a, d, e)
        }
    }),
    ib.fn.extend({
        fadeTo: function(a, b, c, d) {
            return this.filter(w).css("opacity", 0).show().end().animate({
                opacity: b
            },
            a, c, d)
        },
        animate: function(a, b, c, d) {
            var e = ib.isEmptyObject(a),
            f = ib.speed(b, c, d),
            g = function() {
                var b = N(this, ib.extend({},
                a), f);
                g.finish = function() {
                    b.stop(!0)
                },
                (e || ib._data(this, "finish")) && b.stop(!0)
            };
            return g.finish = g,
            e || f.queue === !1 ? this.each(g) : this.queue(f.queue, g)
        },
        stop: function(a, c, d) {
            var e = function(a) {
                var b = a.stop;
                delete a.stop,
                b(d)
            };
            return "string" != typeof a && (d = c, c = a, a = b),
            c && a !== !1 && this.queue(a || "fx", []),
            this.each(function() {
                var b = !0,
                c = null != a && a + "queueHooks",
                f = ib.timers,
                g = ib._data(this);
                if (c) g[c] && g[c].stop && e(g[c]);
                else for (c in g) g[c] && g[c].stop && cd.test(c) && e(g[c]);
                for (c = f.length; c--;) f[c].elem !== this || null != a && f[c].queue !== a || (f[c].anim.stop(d), b = !1, f.splice(c, 1)); (b || !d) && ib.dequeue(this, a)
            })
        },
        finish: function(a) {
            return a !== !1 && (a = a || "fx"),
            this.each(function() {
                var b, c = ib._data(this),
                d = c[a + "queue"],
                e = c[a + "queueHooks"],
                f = ib.timers,
                g = d ? d.length: 0;
                for (c.finish = !0, ib.queue(this, a, []), e && e.cur && e.cur.finish && e.cur.finish.call(this), b = f.length; b--;) f[b].elem === this && f[b].queue === a && (f[b].anim.stop(!0), f.splice(b, 1));
                for (b = 0; g > b; b++) d[b] && d[b].finish && d[b].finish.call(this);
                delete c.finish
            })
        }
    }),
    ib.each({
        slideDown: R("show"),
        slideUp: R("hide"),
        slideToggle: R("toggle"),
        fadeIn: {
            opacity: "show"
        },
        fadeOut: {
            opacity: "hide"
        },
        fadeToggle: {
            opacity: "toggle"
        }
    },
    function(a, b) {
        ib.fn[a] = function(a, c, d) {
            return this.animate(b, a, c, d)
        }
    }),
    ib.speed = function(a, b, c) {
        var d = a && "object" == typeof a ? ib.extend({},
        a) : {
            complete: c || !c && b || ib.isFunction(a) && a,
            duration: a,
            easing: c && b || b && !ib.isFunction(b) && b
        };
        return d.duration = ib.fx.off ? 0 : "number" == typeof d.duration ? d.duration: d.duration in ib.fx.speeds ? ib.fx.speeds[d.duration] : ib.fx.speeds._default,
        (null == d.queue || d.queue === !0) && (d.queue = "fx"),
        d.old = d.complete,
        d.complete = function() {
            ib.isFunction(d.old) && d.old.call(this),
            d.queue && ib.dequeue(this, d.queue)
        },
        d
    },
    ib.easing = {
        linear: function(a) {
            return a
        },
        swing: function(a) {
            return.5 - Math.cos(a * Math.PI) / 2
        }
    },
    ib.timers = [],
    ib.fx = Q.prototype.init,
    ib.fx.tick = function() {
        var a, c = ib.timers,
        d = 0;
        for ($c = ib.now(); d < c.length; d++) a = c[d],
        a() || c[d] !== a || c.splice(d--, 1);
        c.length || ib.fx.stop(),
        $c = b
    },
    ib.fx.timer = function(a) {
        a() && ib.timers.push(a) && ib.fx.start()
    },
    ib.fx.interval = 13,
    ib.fx.start = function() {
        _c || (_c = setInterval(ib.fx.tick, ib.fx.interval))
    },
    ib.fx.stop = function() {
        clearInterval(_c),
        _c = null
    },
    ib.fx.speeds = {
        slow: 600,
        fast: 200,
        _default: 400
    },
    ib.fx.step = {},
    ib.expr && ib.expr.filters && (ib.expr.filters.animated = function(a) {
        return ib.grep(ib.timers,
        function(b) {
            return a === b.elem
        }).length
    }),
    ib.fn.offset = function(a) {
        if (arguments.length) return a === b ? this: this.each(function(b) {
            ib.offset.setOffset(this, a, b)
        });
        var c, d, e = {
            top: 0,
            left: 0
        },
        f = this[0],
        g = f && f.ownerDocument;
        if (g) return c = g.documentElement,
        ib.contains(c, f) ? (typeof f.getBoundingClientRect !== V && (e = f.getBoundingClientRect()), d = S(g), {
            top: e.top + (d.pageYOffset || c.scrollTop) - (c.clientTop || 0),
            left: e.left + (d.pageXOffset || c.scrollLeft) - (c.clientLeft || 0)
        }) : e
    },
    ib.offset = {
        setOffset: function(a, b, c) {
            var d = ib.css(a, "position");
            "static" === d && (a.style.position = "relative");
            var e, f, g = ib(a),
            h = g.offset(),
            i = ib.css(a, "top"),
            j = ib.css(a, "left"),
            k = ("absolute" === d || "fixed" === d) && ib.inArray("auto", [i, j]) > -1,
            l = {},
            m = {};
            k ? (m = g.position(), e = m.top, f = m.left) : (e = parseFloat(i) || 0, f = parseFloat(j) || 0),
            ib.isFunction(b) && (b = b.call(a, c, h)),
            null != b.top && (l.top = b.top - h.top + e),
            null != b.left && (l.left = b.left - h.left + f),
            "using" in b ? b.using.call(a, l) : g.css(l)
        }
    },
    ib.fn.extend({
        position: function() {
            if (this[0]) {
                var a, b, c = {
                    top: 0,
                    left: 0
                },
                d = this[0];
                return "fixed" === ib.css(d, "position") ? b = d.getBoundingClientRect() : (a = this.offsetParent(), b = this.offset(), ib.nodeName(a[0], "html") || (c = a.offset()), c.top += ib.css(a[0], "borderTopWidth", !0), c.left += ib.css(a[0], "borderLeftWidth", !0)),
                {
                    top: b.top - c.top - ib.css(d, "marginTop", !0),
                    left: b.left - c.left - ib.css(d, "marginLeft", !0)
                }
            }
        },
        offsetParent: function() {
            return this.map(function() {
                for (var a = this.offsetParent || W.documentElement; a && !ib.nodeName(a, "html") && "static" === ib.css(a, "position");) a = a.offsetParent;
                return a || W.documentElement
            })
        }
    }),
    ib.each({
        scrollLeft: "pageXOffset",
        scrollTop: "pageYOffset"
    },
    function(a, c) {
        var d = /Y/.test(c);
        ib.fn[a] = function(e) {
            return ib.access(this,
            function(a, e, f) {
                var g = S(a);
                return f === b ? g ? c in g ? g[c] : g.document.documentElement[e] : a[e] : void(g ? g.scrollTo(d ? ib(g).scrollLeft() : f, d ? f: ib(g).scrollTop()) : a[e] = f)
            },
            a, e, arguments.length, null)
        }
    }),
    ib.each({
        Height: "height",
        Width: "width"
    },
    function(a, c) {
        ib.each({
            padding: "inner" + a,
            content: c,
            "": "outer" + a
        },
        function(d, e) {
            ib.fn[e] = function(e, f) {
                var g = arguments.length && (d || "boolean" != typeof e),
                h = d || (e === !0 || f === !0 ? "margin": "border");
                return ib.access(this,
                function(c, d, e) {
                    var f;
                    return ib.isWindow(c) ? c.document.documentElement["client" + a] : 9 === c.nodeType ? (f = c.documentElement, Math.max(c.body["scroll" + a], f["scroll" + a], c.body["offset" + a], f["offset" + a], f["client" + a])) : e === b ? ib.css(c, d, h) : ib.style(c, d, e, h)
                },
                c, g ? e: b, g, null)
            }
        })
    }),
    a.jQuery = a.$ = ib,
    "function" == typeof define && define.amd && define.amd.jQuery && define("jquery", [],
    function() {
        return ib
    })
} (window),
function() {
    var a, b = this,
    c = b.Backbone,
    d = [],
    e = d.push,
    f = d.slice,
    g = d.splice;
    a = "undefined" != typeof exports ? exports: b.Backbone = {},
    a.VERSION = "1.0.0";
    var h = b._;
    h || "undefined" == typeof require || (h = require("underscore")),
    a.$ = b.jQuery || b.Zepto || b.ender || b.$,
    a.noConflict = function() {
        return b.Backbone = c,
        this
    },
    a.emulateHTTP = !1,
    a.emulateJSON = !1;
    var i = a.Events = {
        on: function(a, b, c) {
            if (!k(this, "on", a, [b, c]) || !b) return this;
            this._events || (this._events = {});
            var d = this._events[a] || (this._events[a] = []);
            return d.push({
                callback: b,
                context: c,
                ctx: c || this
            }),
            this
        },
        once: function(a, b, c) {
            if (!k(this, "once", a, [b, c]) || !b) return this;
            var d = this,
            e = h.once(function() {
                d.off(a, e),
                b.apply(this, arguments)
            });
            return e._callback = b,
            this.on(a, e, c)
        },
        off: function(a, b, c) {
            var d, e, f, g, i, j, l, m;
            if (!this._events || !k(this, "off", a, [b, c])) return this;
            if (!a && !b && !c) return this._events = {},
            this;
            for (g = a ? [a] : h.keys(this._events), i = 0, j = g.length; j > i; i++) if (a = g[i], f = this._events[a]) {
                if (this._events[a] = d = [], b || c) for (l = 0, m = f.length; m > l; l++) e = f[l],
                (b && b !== e.callback && b !== e.callback._callback || c && c !== e.context) && d.push(e);
                d.length || delete this._events[a]
            }
            return this
        },
        trigger: function(a) {
            if (!this._events) return this;
            var b = f.call(arguments, 1);
            if (!k(this, "trigger", a, b)) return this;
            var c = this._events[a],
            d = this._events.all;
            return c && l(c, b),
            d && l(d, arguments),
            this
        },
        stopListening: function(a, b, c) {
            var d = this._listeners;
            if (!d) return this;
            var e = !b && !c;
            "object" == typeof b && (c = this),
            a && ((d = {})[a._listenerId] = a);
            for (var f in d) d[f].off(b, c, this),
            e && delete this._listeners[f];
            return this
        }
    },
    j = /\s+/,
    k = function(a, b, c, d) {
        if (!c) return ! 0;
        if ("object" == typeof c) {
            for (var e in c) a[b].apply(a, [e, c[e]].concat(d));
            return ! 1
        }
        if (j.test(c)) {
            for (var f = c.split(j), g = 0, h = f.length; h > g; g++) a[b].apply(a, [f[g]].concat(d));
            return ! 1
        }
        return ! 0
    },
    l = function(a, b) {
        var c, d = -1,
        e = a.length,
        f = b[0],
        g = b[1],
        h = b[2];
        switch (b.length) {
        case 0:
            for (; ++d < e;)(c = a[d]).callback.call(c.ctx);
            return;
        case 1:
            for (; ++d < e;)(c = a[d]).callback.call(c.ctx, f);
            return;
        case 2:
            for (; ++d < e;)(c = a[d]).callback.call(c.ctx, f, g);
            return;
        case 3:
            for (; ++d < e;)(c = a[d]).callback.call(c.ctx, f, g, h);
            return;
        default:
            for (; ++d < e;)(c = a[d]).callback.apply(c.ctx, b)
        }
    },
    m = {
        listenTo: "on",
        listenToOnce: "once"
    };
    h.each(m,
    function(a, b) {
        i[b] = function(b, c, d) {
            var e = this._listeners || (this._listeners = {}),
            f = b._listenerId || (b._listenerId = h.uniqueId("l"));
            return e[f] = b,
            "object" == typeof c && (d = this),
            b[a](c, d, this),
            this
        }
    }),
    i.bind = i.on,
    i.unbind = i.off,
    h.extend(a, i);
    var n = a.Model = function(a, b) {
        var c, d = a || {};
        b || (b = {}),
        this.cid = h.uniqueId("c"),
        this.attributes = {},
        h.extend(this, h.pick(b, o)),
        b.parse && (d = this.parse(d, b) || {}),
        (c = h.result(this, "defaults")) && (d = h.defaults({},
        d, c)),
        this.set(d, b),
        this.changed = {},
        this.initialize.apply(this, arguments)
    },
    o = ["url", "urlRoot", "collection"];
    h.extend(n.prototype, i, {
        changed: null,
        validationError: null,
        idAttribute: "id",
        initialize: function() {},
        toJSON: function() {
            return h.clone(this.attributes)
        },
        sync: function() {
            return a.sync.apply(this, arguments)
        },
        get: function(a) {
            return this.attributes[a]
        },
        escape: function(a) {
            return h.escape(this.get(a))
        },
        has: function(a) {
            return null != this.get(a)
        },
        set: function(a, b, c) {
            var d, e, f, g, i, j, k, l;
            if (null == a) return this;
            if ("object" == typeof a ? (e = a, c = b) : (e = {})[a] = b, c || (c = {}), !this._validate(e, c)) return ! 1;
            f = c.unset,
            i = c.silent,
            g = [],
            j = this._changing,
            this._changing = !0,
            j || (this._previousAttributes = h.clone(this.attributes), this.changed = {}),
            l = this.attributes,
            k = this._previousAttributes,
            this.idAttribute in e && (this.id = e[this.idAttribute]);
            for (d in e) b = e[d],
            h.isEqual(l[d], b) || g.push(d),
            h.isEqual(k[d], b) ? delete this.changed[d] : this.changed[d] = b,
            f ? delete l[d] : l[d] = b;
            if (!i) {
                g.length && (this._pending = !0);
                for (var m = 0,
                n = g.length; n > m; m++) this.trigger("change:" + g[m], this, l[g[m]], c)
            }
            if (j) return this;
            if (!i) for (; this._pending;) this._pending = !1,
            this.trigger("change", this, c);
            return this._pending = !1,
            this._changing = !1,
            this
        },
        unset: function(a, b) {
            return this.set(a, void 0, h.extend({},
            b, {
                unset: !0
            }))
        },
        clear: function(a) {
            var b = {};
            for (var c in this.attributes) b[c] = void 0;
            return this.set(b, h.extend({},
            a, {
                unset: !0
            }))
        },
        hasChanged: function(a) {
            return null == a ? !h.isEmpty(this.changed) : h.has(this.changed, a)
        },
        changedAttributes: function(a) {
            if (!a) return this.hasChanged() ? h.clone(this.changed) : !1;
            var b, c = !1,
            d = this._changing ? this._previousAttributes: this.attributes;
            for (var e in a) h.isEqual(d[e], b = a[e]) || ((c || (c = {}))[e] = b);
            return c
        },
        previous: function(a) {
            return null != a && this._previousAttributes ? this._previousAttributes[a] : null
        },
        previousAttributes: function() {
            return h.clone(this._previousAttributes)
        },
        fetch: function(a) {
            a = a ? h.clone(a) : {},
            void 0 === a.parse && (a.parse = !0);
            var b = this,
            c = a.success;
            return a.success = function(d) {
                return b.set(b.parse(d, a), a) ? (c && c(b, d, a), void b.trigger("sync", b, d, a)) : !1
            },
            L(this, a),
            this.sync("read", this, a)
        },
        save: function(a, b, c) {
            var d, e, f, g = this.attributes;
            if (null == a || "object" == typeof a ? (d = a, c = b) : (d = {})[a] = b, !(!d || c && c.wait || this.set(d, c))) return ! 1;
            if (c = h.extend({
                validate: !0
            },
            c), !this._validate(d, c)) return ! 1;
            d && c.wait && (this.attributes = h.extend({},
            g, d)),
            void 0 === c.parse && (c.parse = !0);
            var i = this,
            j = c.success;
            return c.success = function(a) {
                i.attributes = g;
                var b = i.parse(a, c);
                return c.wait && (b = h.extend(d || {},
                b)),
                h.isObject(b) && !i.set(b, c) ? !1 : (j && j(i, a, c), void i.trigger("sync", i, a, c))
            },
            L(this, c),
            e = this.isNew() ? "create": c.patch ? "patch": "update",
            "patch" === e && (c.attrs = d),
            f = this.sync(e, this, c),
            d && c.wait && (this.attributes = g),
            f
        },
        destroy: function(a) {
            a = a ? h.clone(a) : {};
            var b = this,
            c = a.success,
            d = function() {
                b.trigger("destroy", b, b.collection, a)
            };
            if (a.success = function(e) { (a.wait || b.isNew()) && d(),
                c && c(b, e, a),
                b.isNew() || b.trigger("sync", b, e, a)
            },
            this.isNew()) return a.success(),
            !1;
            L(this, a);
            var e = this.sync("delete", this, a);
            return a.wait || d(),
            e
        },
        url: function() {
            var a = h.result(this, "urlRoot") || h.result(this.collection, "url") || K();
            return this.isNew() ? a: a + ("/" === a.charAt(a.length - 1) ? "": "/") + encodeURIComponent(this.id)
        },
        parse: function(a) {
            return a
        },
        clone: function() {
            return new this.constructor(this.attributes)
        },
        isNew: function() {
            return null == this.id
        },
        isValid: function(a) {
            return this._validate({},
            h.extend(a || {},
            {
                validate: !0
            }))
        },
        _validate: function(a, b) {
            if (!b.validate || !this.validate) return ! 0;
            a = h.extend({},
            this.attributes, a);
            var c = this.validationError = this.validate(a, b) || null;
            return c ? (this.trigger("invalid", this, c, h.extend(b || {},
            {
                validationError: c
            })), !1) : !0
        }
    });
    var p = ["keys", "values", "pairs", "invert", "pick", "omit"];
    h.each(p,
    function(a) {
        n.prototype[a] = function() {
            var b = f.call(arguments);
            return b.unshift(this.attributes),
            h[a].apply(h, b)
        }
    });
    var q = a.Collection = function(a, b) {
        b || (b = {}),
        b.url && (this.url = b.url),
        b.model && (this.model = b.model),
        void 0 !== b.comparator && (this.comparator = b.comparator),
        this._reset(),
        this.initialize.apply(this, arguments),
        a && this.reset(a, h.extend({
            silent: !0
        },
        b))
    },
    r = {
        add: !0,
        remove: !0,
        merge: !0
    },
    s = {
        add: !0,
        merge: !1,
        remove: !1
    };
    h.extend(q.prototype, i, {
        model: n,
        initialize: function() {},
        toJSON: function(a) {
            return this.map(function(b) {
                return b.toJSON(a)
            })
        },
        sync: function() {
            return a.sync.apply(this, arguments)
        },
        add: function(a, b) {
            return this.set(a, h.defaults(b || {},
            s))
        },
        remove: function(a, b) {
            a = h.isArray(a) ? a.slice() : [a],
            b || (b = {});
            var c, d, e, f;
            for (c = 0, d = a.length; d > c; c++) f = this.get(a[c]),
            f && (delete this._byId[f.id], delete this._byId[f.cid], e = this.indexOf(f), this.models.splice(e, 1), this.length--, b.silent || (b.index = e, f.trigger("remove", f, this, b)), this._removeReference(f));
            return this
        },
        set: function(a, b) {
            b = h.defaults(b || {},
            r),
            b.parse && (a = this.parse(a, b)),
            h.isArray(a) || (a = a ? [a] : []);
            var c, d, f, i, j, k = b.at,
            l = this.comparator && null == k && b.sort !== !1,
            m = h.isString(this.comparator) ? this.comparator: null,
            n = [],
            o = [],
            p = {};
            for (c = 0, d = a.length; d > c; c++)(f = this._prepareModel(a[c], b)) && ((i = this.get(f)) ? (b.remove && (p[i.cid] = !0), b.merge && (i.set(f.attributes, b), l && !j && i.hasChanged(m) && (j = !0))) : b.add && (n.push(f), f.on("all", this._onModelEvent, this), this._byId[f.cid] = f, null != f.id && (this._byId[f.id] = f)));
            if (b.remove) {
                for (c = 0, d = this.length; d > c; ++c) p[(f = this.models[c]).cid] || o.push(f);
                o.length && this.remove(o, b)
            }
            if (n.length && (l && (j = !0), this.length += n.length, null != k ? g.apply(this.models, [k, 0].concat(n)) : e.apply(this.models, n)), j && this.sort({
                silent: !0
            }), b.silent) return this;
            for (c = 0, d = n.length; d > c; c++)(f = n[c]).trigger("add", f, this, b);
            return j && this.trigger("sort", this, b),
            this
        },
        reset: function(a, b) {
            b || (b = {});
            for (var c = 0,
            d = this.models.length; d > c; c++) this._removeReference(this.models[c]);
            return b.previousModels = this.models,
            this._reset(),
            this.add(a, h.extend({
                silent: !0
            },
            b)),
            b.silent || this.trigger("reset", this, b),
            this
        },
        push: function(a, b) {
            return a = this._prepareModel(a, b),
            this.add(a, h.extend({
                at: this.length
            },
            b)),
            a
        },
        pop: function(a) {
            var b = this.at(this.length - 1);
            return this.remove(b, a),
            b
        },
        unshift: function(a, b) {
            return a = this._prepareModel(a, b),
            this.add(a, h.extend({
                at: 0
            },
            b)),
            a
        },
        shift: function(a) {
            var b = this.at(0);
            return this.remove(b, a),
            b
        },
        slice: function(a, b) {
            return this.models.slice(a, b)
        },
        get: function(a) {
            return null == a ? void 0 : this._byId[null != a.id ? a.id: a.cid || a]
        },
        at: function(a) {
            return this.models[a]
        },
        where: function(a, b) {
            return h.isEmpty(a) ? b ? void 0 : [] : this[b ? "find": "filter"](function(b) {
                for (var c in a) if (a[c] !== b.get(c)) return ! 1;
                return ! 0
            })
        },
        findWhere: function(a) {
            return this.where(a, !0)
        },
        sort: function(a) {
            if (!this.comparator) throw new Error("Cannot sort a set without a comparator");
            return a || (a = {}),
            h.isString(this.comparator) || 1 === this.comparator.length ? this.models = this.sortBy(this.comparator, this) : this.models.sort(h.bind(this.comparator, this)),
            a.silent || this.trigger("sort", this, a),
            this
        },
        sortedIndex: function(a, b, c) {
            b || (b = this.comparator);
            var d = h.isFunction(b) ? b: function(a) {
                return a.get(b)
            };
            return h.sortedIndex(this.models, a, d, c)
        },
        pluck: function(a) {
            return h.invoke(this.models, "get", a)
        },
        fetch: function(a) {
            a = a ? h.clone(a) : {},
            void 0 === a.parse && (a.parse = !0);
            var b = a.success,
            c = this;
            return a.success = function(d) {
                var e = a.reset ? "reset": "set";
                c[e](d, a),
                b && b(c, d, a),
                c.trigger("sync", c, d, a)
            },
            L(this, a),
            this.sync("read", this, a)
        },
        create: function(a, b) {
            if (b = b ? h.clone(b) : {},
            !(a = this._prepareModel(a, b))) return ! 1;
            b.wait || this.add(a, b);
            var c = this,
            d = b.success;
            return b.success = function(e) {
                b.wait && c.add(a, b),
                d && d(a, e, b)
            },
            a.save(null, b),
            a
        },
        parse: function(a) {
            return a
        },
        clone: function() {
            return new this.constructor(this.models)
        },
        _reset: function() {
            this.length = 0,
            this.models = [],
            this._byId = {}
        },
        _prepareModel: function(a, b) {
            if (a instanceof n) return a.collection || (a.collection = this),
            a;
            b || (b = {}),
            b.collection = this;
            var c = new this.model(a, b);
            return c._validate(a, b) ? c: (this.trigger("invalid", this, a, b), !1)
        },
        _removeReference: function(a) {
            this === a.collection && delete a.collection,
            a.off("all", this._onModelEvent, this)
        },
        _onModelEvent: function(a, b, c, d) { ("add" !== a && "remove" !== a || c === this) && ("destroy" === a && this.remove(b, d), b && a === "change:" + b.idAttribute && (delete this._byId[b.previous(b.idAttribute)], null != b.id && (this._byId[b.id] = b)), this.trigger.apply(this, arguments))
        }
    });
    var t = ["forEach", "each", "map", "collect", "reduce", "foldl", "inject", "reduceRight", "foldr", "find", "detect", "filter", "select", "reject", "every", "all", "some", "any", "include", "contains", "invoke", "max", "min", "toArray", "size", "first", "head", "take", "initial", "rest", "tail", "drop", "last", "without", "indexOf", "shuffle", "lastIndexOf", "isEmpty", "chain"];
    h.each(t,
    function(a) {
        q.prototype[a] = function() {
            var b = f.call(arguments);
            return b.unshift(this.models),
            h[a].apply(h, b)
        }
    });
    var u = ["groupBy", "countBy", "sortBy"];
    h.each(u,
    function(a) {
        q.prototype[a] = function(b, c) {
            var d = h.isFunction(b) ? b: function(a) {
                return a.get(b)
            };
            return h[a](this.models, d, c)
        }
    });
    var v = a.View = function(a) {
        this.cid = h.uniqueId("view"),
        this._configure(a || {}),
        this._ensureElement(),
        this.initialize.apply(this, arguments),
        this.delegateEvents()
    },
    w = /^(\S+)\s*(.*)$/,
    x = ["model", "collection", "el", "id", "attributes", "className", "tagName", "events"];
    h.extend(v.prototype, i, {
        tagName: "div",
        $: function(a) {
            return this.$el.find(a)
        },
        initialize: function() {},
        render: function() {
            return this
        },
        remove: function() {
            return this.$el.remove(),
            this.stopListening(),
            this
        },
        setElement: function(b, c) {
            return this.$el && this.undelegateEvents(),
            this.$el = b instanceof a.$ ? b: a.$(b),
            this.el = this.$el[0],
            c !== !1 && this.delegateEvents(),
            this
        },
        delegateEvents: function(a) {
            if (!a && !(a = h.result(this, "events"))) return this;
            this.undelegateEvents();
            for (var b in a) {
                var c = a[b];
                if (h.isFunction(c) || (c = this[a[b]]), c) {
                    var d = b.match(w),
                    e = d[1],
                    f = d[2];
                    c = h.bind(c, this),
                    e += ".delegateEvents" + this.cid,
                    "" === f ? this.$el.on(e, c) : this.$el.on(e, f, c)
                }
            }
            return this
        },
        undelegateEvents: function() {
            return this.$el.off(".delegateEvents" + this.cid),
            this
        },
        _configure: function(a) {
            this.options && (a = h.extend({},
            h.result(this, "options"), a)),
            h.extend(this, h.pick(a, x)),
            this.options = a
        },
        _ensureElement: function() {
            if (this.el) this.setElement(h.result(this, "el"), !1);
            else {
                var b = h.extend({},
                h.result(this, "attributes"));
                this.id && (b.id = h.result(this, "id")),
                this.className && (b["class"] = h.result(this, "className"));
                var c = a.$("<" + h.result(this, "tagName") + ">").attr(b);
                this.setElement(c, !1)
            }
        }
    }),
    a.sync = function(b, c, d) {
        var e = y[b];
        h.defaults(d || (d = {}), {
            emulateHTTP: a.emulateHTTP,
            emulateJSON: a.emulateJSON
        });
        var f = {
            type: e,
            dataType: "json"
        };
        if (d.url || (f.url = h.result(c, "url") || K()), null != d.data || !c || "create" !== b && "update" !== b && "patch" !== b || (f.contentType = "application/json", f.data = JSON.stringify(d.attrs || c.toJSON(d))), d.emulateJSON && (f.contentType = "application/x-www-form-urlencoded", f.data = f.data ? {
            model: f.data
        }: {}), d.emulateHTTP && ("PUT" === e || "DELETE" === e || "PATCH" === e)) {
            f.type = "POST",
            d.emulateJSON && (f.data._method = e);
            var g = d.beforeSend;
            d.beforeSend = function(a) {
                return a.setRequestHeader("X-HTTP-Method-Override", e),
                g ? g.apply(this, arguments) : void 0
            }
        }
        "GET" === f.type || d.emulateJSON || (f.processData = !1),
        "PATCH" !== f.type || !window.ActiveXObject || window.external && window.external.msActiveXFilteringEnabled || (f.xhr = function() {
            return new ActiveXObject("Microsoft.XMLHTTP")
        });
        var i = d.xhr = a.ajax(h.extend(f, d));
        return c.trigger("request", c, i, d),
        i
    };
    var y = {
        create: "POST",
        update: "PUT",
        patch: "PATCH",
        "delete": "DELETE",
        read: "GET"
    };
    a.ajax = function() {
        return a.$.ajax.apply(a.$, arguments)
    };
    var z = a.Router = function(a) {
        a || (a = {}),
        a.routes && (this.routes = a.routes),
        this._bindRoutes(),
        this.initialize.apply(this, arguments)
    },
    A = /\((.*?)\)/g,
    B = /(\(\?)?:\w+/g,
    C = /\*\w+/g,
    D = /[\-{}\[\]+?.,\\\^$|#\s]/g;
    h.extend(z.prototype, i, {
        initialize: function() {},
        route: function(b, c, d) {
            h.isRegExp(b) || (b = this._routeToRegExp(b)),
            h.isFunction(c) && (d = c, c = ""),
            d || (d = this[c]);
            var e = this;
            return a.history.route(b,
            function(f) {
                var g = e._extractParameters(b, f);
                d && d.apply(e, g),
                e.trigger.apply(e, ["route:" + c].concat(g)),
                e.trigger("route", c, g),
                a.history.trigger("route", e, c, g)
            }),
            this
        },
        navigate: function(b, c) {
            return a.history.navigate(b, c),
            this
        },
        _bindRoutes: function() {
            if (this.routes) {
                this.routes = h.result(this, "routes");
                for (var a, b = h.keys(this.routes); null != (a = b.pop());) this.route(a, this.routes[a])
            }
        },
        _routeToRegExp: function(a) {
            return a = a.replace(D, "\\$&").replace(A, "(?:$1)?").replace(B,
            function(a, b) {
                return b ? a: "([^/]+)"
            }).replace(C, "(.*?)"),
            new RegExp("^" + a + "$")
        },
        _extractParameters: function(a, b) {
            var c = a.exec(b).slice(1);
            return h.map(c,
            function(a) {
                return a ? decodeURIComponent(a) : null
            })
        }
    });
    var E = a.History = function() {
        this.handlers = [],
        h.bindAll(this, "checkUrl"),
        "undefined" != typeof window && (this.location = window.location, this.history = window.history)
    },
    F = /^[#\/]|\s+$/g,
    G = /^\/+|\/+$/g,
    H = /msie [\w.]+/,
    I = /\/$/;
    E.started = !1,
    h.extend(E.prototype, i, {
        interval: 50,
        getHash: function(a) {
            var b = (a || this).location.href.match(/#(.*)$/);
            return b ? b[1] : ""
        },
        getFragment: function(a, b) {
            if (null == a) if (this._hasPushState || !this._wantsHashChange || b) {
                a = this.location.pathname;
                var c = this.root.replace(I, "");
                a.indexOf(c) || (a = a.substr(c.length))
            } else a = this.getHash();
            return a.replace(F, "")
        },
        start: function(b) {
            if (E.started) throw new Error("Backbone.history has already been started");
            E.started = !0,
            this.options = h.extend({},
            {
                root: "/"
            },
            this.options, b),
            this.root = this.options.root,
            this._wantsHashChange = this.options.hashChange !== !1,
            this._wantsPushState = !!this.options.pushState,
            this._hasPushState = !!(this.options.pushState && this.history && this.history.pushState);
            var c = this.getFragment(),
            d = document.documentMode,
            e = H.exec(navigator.userAgent.toLowerCase()) && (!d || 7 >= d);
            this.root = ("/" + this.root + "/").replace(G, "/"),
            e && this._wantsHashChange && (this.iframe = a.$('<iframe src="javascript:0" tabindex="-1" />').hide().appendTo("body")[0].contentWindow, this.navigate(c)),
            this._hasPushState ? a.$(window).on("popstate", this.checkUrl) : this._wantsHashChange && "onhashchange" in window && !e ? a.$(window).on("hashchange", this.checkUrl) : this._wantsHashChange && (this._checkUrlInterval = setInterval(this.checkUrl, this.interval)),
            this.fragment = c;
            var f = this.location,
            g = f.pathname.replace(/[^\/]$/, "$&/") === this.root;
            return this._wantsHashChange && this._wantsPushState && !this._hasPushState && !g ? (this.fragment = this.getFragment(null, !0), this.location.replace(this.root + this.location.search + "#" + this.fragment), !0) : (this._wantsPushState && this._hasPushState && g && f.hash && (this.fragment = this.getHash().replace(F, ""), this.history.replaceState({},
            document.title, this.root + this.fragment + f.search)), this.options.silent ? void 0 : this.loadUrl())
        },
        stop: function() {
            a.$(window).off("popstate", this.checkUrl).off("hashchange", this.checkUrl),
            clearInterval(this._checkUrlInterval),
            E.started = !1
        },
        route: function(a, b) {
            this.handlers.unshift({
                route: a,
                callback: b
            })
        },
        checkUrl: function() {
            var a = this.getFragment();
            return a === this.fragment && this.iframe && (a = this.getFragment(this.getHash(this.iframe))),
            a === this.fragment ? !1 : (this.iframe && this.navigate(a), void(this.loadUrl() || this.loadUrl(this.getHash())))
        },
        loadUrl: function(a) {
            var b = this.fragment = this.getFragment(a),
            c = h.any(this.handlers,
            function(a) {
                return a.route.test(b) ? (a.callback(b), !0) : void 0
            });
            return c
        },
        navigate: function(a, b) {
            if (!E.started) return ! 1;
            if (b && b !== !0 || (b = {
                trigger: b
            }), a = this.getFragment(a || ""), this.fragment !== a) {
                this.fragment = a;
                var c = this.root + a;
                if (this._hasPushState) this.history[b.replace ? "replaceState": "pushState"]({},
                document.title, c);
                else {
                    if (!this._wantsHashChange) return this.location.assign(c);
                    this._updateHash(this.location, a, b.replace),
                    this.iframe && a !== this.getFragment(this.getHash(this.iframe)) && (b.replace || this.iframe.document.open().close(), this._updateHash(this.iframe.location, a, b.replace))
                }
                b.trigger && this.loadUrl(a)
            }
        },
        _updateHash: function(a, b, c) {
            if (c) {
                var d = a.href.replace(/(javascript:|#).*$/, "");
                a.replace(d + "#" + b)
            } else a.hash = "#" + b
        }
    }),
    a.history = new E;
    var J = function(a, b) {
        var c, d = this;
        c = a && h.has(a, "constructor") ? a.constructor: function() {
            return d.apply(this, arguments)
        },
        h.extend(c, d, b);
        var e = function() {
            this.constructor = c
        };
        return e.prototype = d.prototype,
        c.prototype = new e,
        a && h.extend(c.prototype, a),
        c.__super__ = d.prototype,
        c
    };
    n.extend = q.extend = z.extend = v.extend = E.extend = J;
    var K = function() {
        throw new Error('A "url" property or function must be specified')
    },
    L = function(a, b) {
        var c = b.error;
        b.error = function(d) {
            c && c(a, d, b),
            a.trigger("error", a, d, b)
        }
    }
}.call(this),
define("backbone", ["underscore", "jquery"],
function(a) {
    return function() {
        var b;
        return b || a.Backbone
    }
} (this)),
define("event", ["backbone", "underscore"],
function(a, b) {
    
}),
define("helper", ["underscore"],
function(a) {
    
}),
!
function(a, b) {
    function c(a, b) {
        
    }
    var d = b.prototype.trim,
    e = b.prototype.trimRight,
    f = b.prototype.trimLeft,
    g = function(a) {
        return 1 * a || 0
    },
    h = function(a, b) {
        
    },
    i = [].slice,
    j = function(a) {
        return null == a ? "\\s": a.source ? a.source: "[" + o.escapeRegExp(a) + "]"
    },
    k = {
        
    },
    l = {};
    for (var m in k) l[k[m]] = m;
    l["'"] = "#39";
    var n = function() {
        
    } (),
    o = {
        
    };
    o.strip = o.trim,
    o.lstrip = o.ltrim,
    o.rstrip = o.rtrim,
    o.center = o.lrpad,
    o.rjust = o.lpad,
    o.ljust = o.rpad,
    o.contains = o.include,
    o.q = o.quote,
    o.toBool = o.toBoolean,
    "undefined" != typeof exports && ("undefined" != typeof module && module.exports && (module.exports = o), exports._s = o),
    "function" == typeof define && define.amd && define("underscore.string", [],
    function() {
        return o
    }),
    a._ = a._ || {},
    a._.string = a._.str = o
} (this, String),
function(a) {
    
    function c(a, b) {        
    }
    function d(a, b) {        
    }
    for (var db, eb, fb = "2.5.1",
    rb = "undefined" != typeof module && module.exports && "undefined" != typeof require, sb = /^\/?Date\((\-?\d+)/i, tb = /(\-)?(?:(\d*)\.)?(\d+)\:(\d+)(?:\:(\d+)\.?(\d{3})?)?/, ub = /^(-)?P(?:(?:([0-9,.]*)Y)?(?:([0-9,.]*)M)?(?:([0-9,.]*)D)?(?:T(?:([0-9,.]*)H)?(?:([0-9,.]*)M)?(?:([0-9,.]*)S)?)?|([0-9,.]*)W)$/, vb = /(\[[^\[]*\])|(\\)?(Mo|MM?M?M?|Do|DDDo|DD?D?D?|ddd?d?|do?|w[o|w]?|W[o|W]?|YYYYYY|YYYYY|YYYY|YY|gg(ggg?)?|GG(GGG?)?|e|E|a|A|hh?|HH?|mm?|ss?|S{1,4}|X|zz?|ZZ?|.)/g, wb = /(\[[^\[]*\])|(\\)?(LT|LL?L?L?|l{1,4})/g, xb = /\d\d?/, yb = /\d{1,3}/, zb = /\d{1,4}/, Ab = /[+\-]?\d{1,6}/, Bb = /\d+/, Cb = /[0-9]*['a-z\u00A0-\u05FF\u0700-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+|[\u0600-\u06FF\/]+(\s*?[\u0600-\u06FF]+){1,2}/i, Db = /Z|[\+\-]\d\d:?\d\d/gi, Eb = /T/i, Fb = /[\+\-]?\d+(\.\d{1,3})?/, Gb = /\d/, Hb = /\d\d/, Ib = /\d{3}/, Jb = /\d{4}/, Kb = /[+-]?\d{6}/, Lb = /[+-]?\d+/, Mb = /^\s*(?:[+-]\d{6}|\d{4})-(?:(\d\d-\d\d)|(W\d\d$)|(W\d\d-\d)|(\d\d\d))((T| )(\d\d(:\d\d(:\d\d(\.\d+)?)?)?)?([\+\-]\d\d(?::?\d\d)?|\s*Z)?)?$/, Nb = "YYYY-MM-DDTHH:mm:ssZ", Ob = [["YYYYYY-MM-DD", /[+-]\d{6}-\d{2}-\d{2}/], ["YYYY-MM-DD", /\d{4}-\d{2}-\d{2}/], ["GGGG-[W]WW-E", /\d{4}-W\d{2}-\d/], ["GGGG-[W]WW", /\d{4}-W\d{2}/], ["YYYY-DDD", /\d{4}-\d{3}/]], Pb = [["HH:mm:ss.SSSS", /(T| )\d\d:\d\d:\d\d\.\d{1,3}/], ["HH:mm:ss", /(T| )\d\d:\d\d:\d\d/], ["HH:mm", /(T| )\d\d:\d\d/], ["HH", /(T| )\d\d/]], Qb = /([\+\-]|\d\d)/gi, Rb = "Date|Hours|Minutes|Seconds|Milliseconds".split("|"), Sb = {
        
    },
    Tb = {},
    Ub = {},
    Vb = {},
    Wb = "DDD w W M D d".split(" "), Xb = "M D H h m s w W".split(" "), Yb = {},
    Zb = ["months", "monthsShort", "weekdays", "weekdaysShort", "weekdaysMin"]; Wb.length;) eb = Wb.pop(),
    Yb[eb + "o"] = d(Yb[eb], eb);
    for (; Xb.length;) eb = Xb.pop(),
    Yb[eb + eb] = c(Yb[eb], 2);    
    rb ? (module.exports = db, cb()) : "function" == typeof define && define.amd ? define("moment") : cb()
}.call(this),

function(a) {
    "function" == typeof define && define.amd ? define("jquery-ui", ["jquery"], a) : a(jQuery)
} (function(a) {}),

function(a, b, c) {
    var h, i, j = "[object OperaMini]" == Object.prototype.toString.call(a.operamini),
    k = "placeholder" in b.createElement("input") && !j,
    l = "placeholder" in b.createElement("textarea") && !j,
    m = c.fn,
    n = c.valHooks,
    o = c.propHooks;
    k && l ? (i = m.placeholder = function() {},
    i.input = i.textarea = !0) : (i = m.placeholder = function() {})
} (this, document, jQuery),


define("views/services/servicesContainer", ["backbone", "event",  "helper"],
function(a, b, c, d, e, f, g, h, i, j) {
     
}),
define("views/services/locationInput", ["backbone", "helper", "event"],
function(a, b, c) {
     
}),


define("views/otherService", ["event", "backbone", ""],
function(a, b, c, d, e) {
     
}),
define("models/waybill", ["backbone", "helper"],
function(a, b) {
    return a.Model.extend({
        defaults: {
            isChecked: !0
        }
    },
    {
        parse: function(a) {
            
        },
        appendPreviousScanTime: function(a) {
            var b;
            return _.each(a,
            function(a) {
                b && (a.lastRouteScanDateTime = b.scanDateTime),
                b = a
            }),
            a
        },
        validateBillNumber: function(a) {
            var b = /^(\d{2}|[a-zA-Z0-9])\d{7}$/;
            return b.test(a.trim())
        },
        validateBillNumbers: function(a) {
            var b = !0,
            c = this;
            return _.each(a,
            function(a) {
                a.length && !c.validateBillNumber(a) && (b = !1)
            }),
            b
        }
    })
}),
define("collections/waybills", ["backbone", "models/waybill", "underscore", "helper"],
function(a, b, c, d) {
    return a.Collection.extend({
        model: b,
        initialize: function() {
            this.billNumbers = []
        },
        parse: function(a) {
            return a = c.map(a,
            function(a) {
                return b.parse(a)
            })
        },
        findWaybillById: function(a) {
            return this.findWhere({
                id: a
            })
        },
        updateSubscribedStatus: function(a) {
            c.each(this.models,
            function(b) {
                b.get("delivered") || b.set("isChecked", a)
            })
        },
        getSubscribedWaybills: function() {
            return this.where({
                isChecked: !0,
                delivered: !1
            })
        },
        isAllChecked: function() {
            var a = this.subsribableWaybills();
            return a.length ? this.getSubscribedWaybills().length === a.length: !1
        },
        subsribableWaybills: function() {
            return this.where({
                delivered: !1
            })
        },
        subscribeSelectedWaybillsWithEmails: function(b) {
            var e = c.map(this.getSubscribedWaybills(),
            function(a) {
                return a.id
            });
            return a.ajax({
                url: d.getRESTfulDomain("bills/" + e.join(",") + "/subscription/email?lang=" + d.getSiteLanguage() + "&region=" + d.getSiteLocation()),
                type: "POST",
                data: JSON.stringify(b),
                headers: {
                    "Content-Type": "application/json"
                }
            })
        }
    })
}),







function(a) {
    "function" == typeof define && define.amd ? define("tokenfield", ["jquery"], a) : "object" == typeof exports ? module.exports = global.window && global.window.$ ? a(global.window.$) : function(b) {
        if (!b.$ && !b.fn) throw new Error("Tokenfield requires a window object with jQuery or a jQuery instance");
        return a(b.$ || b)
    }: a(jQuery)
} (function(a, b) {
    var c = function(c, d) {
        var e = this;
        this.$element = a(c),
        this.textDirection = this.$element.css("direction"),
        this.options = a.extend(!0, {},
        a.fn.tokenfield.defaults, {
            tokens: this.$element.val()
        },
        this.$element.data(), d),
        this._delimiters = "string" == typeof this.options.delimiter ? [this.options.delimiter] : this.options.delimiter,
        this._triggerKeys = a.map(this._delimiters,
        function(a) {
            return a.charCodeAt(0)
        }),
        this._firstDelimiter = this._delimiters[0];
        var f = a.inArray(" ", this._delimiters),
        g = a.inArray("-", this._delimiters);
        f >= 0 && (this._delimiters[f] = "\\s"),
        g >= 0 && (delete this._delimiters[g], this._delimiters.unshift("-"));
        var h = ["\\", "$", "[", "{", "^", ".", "|", "?", "*", "+", "(", ")"];
        a.each(this._delimiters,
        function(b, c) {
            var d = a.inArray(c, h);
            d >= 0 && (e._delimiters[b] = "\\" + c)
        });
        var i, j = b && "function" == typeof b.getMatchedCSSRules ? b.getMatchedCSSRules(c) : null,
        k = c.style.width,
        l = this.$element.width();
        j && a.each(j,
        function(a, b) {
            b.style.width && (i = b.style.width)
        });
        var m = "rtl" === a("body").css("direction") ? "right": "left",
        n = {
            position: this.$element.css("position")
        };
        n[m] = this.$element.css(m),
        this.$element.data("original-styles", n).data("original-tabindex", this.$element.prop("tabindex")).css("position", "absolute").css(m, "-10000px").prop("tabindex", -1),
        this.$wrapper = a('<div class="tokenfield form-control" />'),
        this.$element.hasClass("input-lg") && this.$wrapper.addClass("input-lg"),
        this.$element.hasClass("input-sm") && this.$wrapper.addClass("input-sm"),
        "rtl" === this.textDirection && this.$wrapper.addClass("rtl");
        var o = this.$element.prop("id") || (new Date).getTime() + "" + Math.floor(100 * (1 + Math.random()));
        this.$input = a('<input type="text" class="token-input" autocomplete="off" />').appendTo(this.$wrapper).prop("placeholder", this.$element.prop("placeholder")).prop("id", o + "-tokenfield").prop("tabindex", this.$element.data("original-tabindex"));
        var p = a('label[for="' + this.$element.prop("id") + '"]');
        if (p.length && p.prop("for", this.$input.prop("id")), this.$copyHelper = a('<input type="text" />').css("position", "absolute").css(m, "-10000px").prop("tabindex", -1).prependTo(this.$wrapper), k ? this.$wrapper.css("width", k) : i ? this.$wrapper.css("width", i) : this.$element.parents(".form-inline").length && this.$wrapper.width(l), (this.$element.prop("disabled") || this.$element.parents("fieldset[disabled]").length) && this.disable(), this.$mirror = a('<span style="position:absolute; top:-999px; left:0; white-space:pre;"/>'), this.$input.css("min-width", this.options.minWidth + "px"), a.each(["fontFamily", "fontSize", "fontWeight", "fontStyle", "letterSpacing", "textTransform", "wordSpacing", "textIndent"],
        function(a, b) {
            e.$mirror[0].style[b] = e.$input.css(b)
        }), this.$mirror.appendTo("body"), this.$wrapper.insertBefore(this.$element), this.$element.prependTo(this.$wrapper), this.update(), this.setTokens(this.options.tokens, !1, !1), this.listen(), !a.isEmptyObject(this.options.autocomplete)) {
            var q = "rtl" === this.textDirection ? "right": "left",
            r = a.extend({
                minLength: this.options.showAutocompleteOnFocus ? 0 : null,
                position: {
                    my: q + " top",
                    at: q + " bottom",
                    of: this.$wrapper
                }
            },
            this.options.autocomplete);
            this.$input.autocomplete(r)
        }
        if (!a.isEmptyObject(this.options.typeahead)) {
            var s = a.extend({
                minLength: this.options.showAutocompleteOnFocus ? 0 : null
            },
            this.options.typeahead);
            this.$input.typeahead(null, s),
            this.typeahead = !0
        }
        this.$element.trigger("tokenfield:initialize")
    };
    c.prototype = {
        constructor: c,
        createToken: function(b, c) {
            "string" == typeof b && (b = {
                value: b,
                label: b
            }),
            "undefined" == typeof c && (c = !0);
            var d = this,
            e = a.trim(b.value),
            f = b.label && b.label.length ? a.trim(b.label) : e;
            if (e.length && f.length && !(e.length < this.options.minLength)) {
                if (this.options.limit && this.getTokens().length >= this.options.limit) return void(this.options.leakCallback && this.options.leakCallback());
                var g = a.Event("tokenfield:preparetoken");
                if (g.token = {
                    value: e,
                    label: f
                },
                this.$element.trigger(g), g.token) {
                    if (e = g.token.value, f = g.token.label, !this.options.allowDuplicates && a.grep(this.getTokens(),
                    function(a) {
                        return a.value === e
                    }).length) {
                        var h = a.Event("tokenfield:preventduplicate");
                        h.token = {
                            value: e,
                            label: f
                        },
                        this.$element.trigger(h);
                        var i = this.$wrapper.find('.token[data-value="' + e + '"]').addClass("duplicate");
                        return setTimeout(function() {
                            i.removeClass("duplicate")
                        },
                        250),
                        !1
                    }
                    var j = a('<div class="token" />').attr("data-value", e).append('<span class="token-label" />').append('<a href="#" class="close" tabindex="-1">&times;</a>');
                    this.$input.hasClass("tt-input") ? this.$input.parent().before(j) : this.$input.before(j),
                    this.$input.css("width", this.options.minWidth + "px");
                    var k = j.find(".token-label"),
                    l = j.find(".close");
                    this.maxTokenWidth || (this.maxTokenWidth = this.$wrapper.width() - l.outerWidth() - parseInt(l.css("margin-left"), 10) - parseInt(l.css("margin-right"), 10) - parseInt(j.css("border-left-width"), 10) - parseInt(j.css("border-right-width"), 10) - parseInt(j.css("padding-left"), 10) - parseInt(j.css("padding-right"), 10), parseInt(k.css("border-left-width"), 10) - parseInt(k.css("border-right-width"), 10) - parseInt(k.css("padding-left"), 10) - parseInt(k.css("padding-right"), 10), parseInt(k.css("margin-left"), 10) - parseInt(k.css("margin-right"), 10)),
                    k.text(f).css("max-width", this.maxTokenWidth - 5),
                    j.on("mousedown",
                    function() {
                        return d.disabled ? !1 : void(d.preventDeactivation = !0)
                    }).on("click",
                    function(a) {
                        return d.disabled ? !1 : (d.preventDeactivation = !1, a.ctrlKey || a.metaKey ? (a.preventDefault(), d.toggle(j)) : void d.activate(j, a.shiftKey, a.shiftKey))
                    }).on("dblclick",
                    function() {
                        return d.disabled || !d.options.allowEditing ? !1 : void d.edit(j)
                    }),
                    l.on("click", a.proxy(this.remove, this));
                    var m = a.Event("tokenfield:createtoken");
                    m.token = g.token,
                    m.relatedTarget = j.get(0),
                    this.$element.trigger(m);
                    var n = a.Event("change");
                    return n.initiator = "tokenfield",
                    c && this.$element.val(this.getTokensList()).trigger(n),
                    this.update(),
                    this.$input.get(0)
                }
            }
        },
        setTokens: function(b, c, d) {
            if (b) {
                c || this.$wrapper.find(".token").remove(),
                "undefined" == typeof d && (d = !0),
                "string" == typeof b && (b = this._delimiters.length ? b.split(new RegExp("[" + this._delimiters.join("") + "]")) : [b]);
                var e = this;
                return a.each(b,
                function(a, b) {
                    e.createToken(b, d)
                }),
                this.$element.get(0)
            }
        },
        getTokenData: function(b) {
            var c = b.map(function() {
                var b = a(this);
                return {
                    value: b.attr("data-value"),
                    label: b.find(".token-label").text()
                }
            }).get();
            return 1 == c.length && (c = c[0]),
            c
        },
        getTokens: function(b) {
            var c = this,
            d = [],
            e = b ? ".active": "";
            return this.$wrapper.find(".token" + e).each(function() {
                d.push(c.getTokenData(a(this)))
            }),
            d
        },
        getTokensList: function(b, c, d) {
            b = b || this._firstDelimiter,
            c = "undefined" != typeof c && null !== c ? c: this.options.beautify;
            var e = b + (c && " " !== b ? " ": "");
            return a.map(this.getTokens(d),
            function(a) {
                return a.value
            }).join(e)
        },
        getInput: function() {
            return this.$input.val()
        },
        listen: function() {
            var c = this;
            this.$element.on("change", a.proxy(this.change, this)),
            this.$wrapper.on("mousedown", a.proxy(this.focusInput, this)),
            this.$input.on("focus", a.proxy(this.focus, this)).on("blur", a.proxy(this.blur, this)).on("paste", a.proxy(this.paste, this)).on("keydown", a.proxy(this.keydown, this)).on("keypress", a.proxy(this.keypress, this)).on("keyup", a.proxy(this.keyup, this)),
            this.$copyHelper.on("focus", a.proxy(this.focus, this)).on("blur", a.proxy(this.blur, this)).on("keydown", a.proxy(this.keydown, this)).on("keyup", a.proxy(this.keyup, this)),
            this.$input.on("keypress", a.proxy(this.update, this)).on("keyup", a.proxy(this.update, this)),
            this.$input.on("autocompletecreate",
            function() {
                var b = a(this).data("ui-autocomplete").menu.element,
                d = c.$wrapper.outerWidth() - parseInt(b.css("border-left-width"), 10) - parseInt(b.css("border-right-width"), 10);
                b.css("min-width", d + "px")
            }).on("autocompleteselect",
            function(a, b) {
                return c.createToken(b.item) && (c.$input.val(""), c.$input.data("edit") && c.unedit(!0)),
                !1
            }).on("typeahead:selected",
            function(a, b) {
                c.createToken(b) && (c.$input.typeahead("val", ""), c.$input.data("edit") && c.unedit(!0))
            }).on("typeahead:autocompleted",
            function() {
                c.createToken(c.$input.val()),
                c.$input.typeahead("val", ""),
                c.$input.data("edit") && c.unedit(!0)
            }),
            a(b).on("resize", a.proxy(this.update, this))
        },
        keydown: function(b) {
            function c(a) {
                if (e.$input.is(document.activeElement)) {
                    if (e.$input.val().length > 0) return;
                    a += "All";
                    var c = e.$input.hasClass("tt-input") ? e.$input.parent()[a](".token:first") : e.$input[a](".token:first");
                    if (!c.length) return;
                    e.preventInputFocus = !0,
                    e.preventDeactivation = !0,
                    e.activate(c),
                    b.preventDefault()
                } else e[a](b.shiftKey),
                b.preventDefault()
            }
            function d(c) {
                if (b.shiftKey) {
                    if (e.$input.is(document.activeElement)) {
                        if (e.$input.val().length > 0) return;
                        var d = e.$input.hasClass("tt-input") ? e.$input.parent()[c + "All"](".token:first") : e.$input[c + "All"](".token:first");
                        if (!d.length) return;
                        e.activate(d)
                    }
                    var f = "prev" === c ? "next": "prev",
                    g = "prev" === c ? "first": "last";
                    e.firstActiveToken[f + "All"](".token").each(function() {
                        e.deactivate(a(this))
                    }),
                    e.activate(e.$wrapper.find(".token:" + g), !0, !0),
                    b.preventDefault()
                }
            }
            if (this.focused) {
                var e = this;
                switch (b.keyCode) {
                case 8:
                    if (!this.$input.is(document.activeElement)) break;
                    this.lastInputValue = this.$input.val();
                    break;
                case 37:
                    c("rtl" === this.textDirection ? "next": "prev");
                    break;
                case 38:
                    d("prev");
                    break;
                case 39:
                    c("rtl" === this.textDirection ? "prev": "next");
                    break;
                case 40:
                    d("next");
                    break;
                case 65:
                    if (this.$input.val().length > 0 || !b.ctrlKey && !b.metaKey) break;
                    this.activateAll(),
                    b.preventDefault();
                    break;
                case 9:
                case 13:
                    if (this.$input.data("ui-autocomplete") && this.$input.data("ui-autocomplete").menu.element.find("li:has(a.ui-state-focus)").length) break;
                    if (this.$input.hasClass("tt-input") && this.$wrapper.find(".tt-cursor").length) break;
                    if (this.$input.hasClass("tt-input") && this.$wrapper.find(".tt-hint").val().length) break;
                    if (this.$input.is(document.activeElement) && this.$input.val().length || this.$input.data("edit")) return this.createTokensFromInput(b, this.$input.data("edit"));
                    if (13 === b.keyCode) {
                        if (!this.$copyHelper.is(document.activeElement) || 1 !== this.$wrapper.find(".token.active").length) break;
                        if (!e.options.allowEditing) break;
                        this.edit(this.$wrapper.find(".token.active"))
                    }
                }
                this.lastKeyDown = b.keyCode
            }
        },
        keypress: function(b) {
            return this.lastKeyPressCode = b.keyCode,
            this.lastKeyPressCharCode = b.charCode,
            -1 !== a.inArray(b.charCode, this._triggerKeys) && this.$input.is(document.activeElement) ? (this.$input.val() && this.createTokensFromInput(b), !1) : void 0
        },
        keyup: function(a) {
            if (this.preventInputFocus = !1, this.focused) {
                switch (a.keyCode) {
                case 8:
                    if (this.$input.is(document.activeElement)) {
                        if (this.$input.val().length || this.lastInputValue.length && 8 === this.lastKeyDown) break;
                        this.preventDeactivation = !0;
                        var b = this.$input.hasClass("tt-input") ? this.$input.parent().prevAll(".token:first") : this.$input.prevAll(".token:first");
                        if (!b.length) break;
                        this.activate(b)
                    } else this.remove(a);
                    break;
                case 46:
                    this.remove(a, "next")
                }
                this.lastKeyUp = a.keyCode
            }
        },
        focus: function() {
            this.focused = !0,
            this.$wrapper.addClass("focus"),
            this.$input.is(document.activeElement) && (this.$wrapper.find(".active").removeClass("active"), this.firstActiveToken = null, this.options.showAutocompleteOnFocus && this.search())
        },
        blur: function(a) {
            this.focused = !1,
            this.$wrapper.removeClass("focus"),
            this.preventDeactivation || this.$element.is(document.activeElement) || (this.$wrapper.find(".active").removeClass("active"), this.firstActiveToken = null),
            !this.preventCreateTokens && (this.$input.data("edit") && !this.$input.is(document.activeElement) || this.options.createTokensOnBlur) && this.createTokensFromInput(a),
            this.preventDeactivation = !1,
            this.preventCreateTokens = !1
        },
        paste: function(a) {
            var b = this;
            try {
                if (clipboardData) {
                    var c = clipboardData.getData("Text");
                    /^\d/.test(c) && (a.clipData = c.replace(/^\s+|\s+$/g, "").replace(/(\r\n|\n|\r)/gm, " "))
                }
            } catch(d) {}
            setTimeout(function() {
                b.createTokensFromInput(a)
            },
            1)
        },
        change: function(a) {
            "tokenfield" !== a.initiator && this.setTokens(this.$element.val())
        },
        createTokensFromInput: function(a, b) {
            if (a.clipData && this.$input.val(a.clipData), !(this.$input.val().length < this.options.minLength)) {
                var c = this.getTokensList();
                return this.setTokens(this.$input.val(), !0),
                c == this.getTokensList() && this.$input.val().length ? !1 : (this.$input.hasClass("tt-input") ? this.$input.typeahead("val", "") : this.$input.val(""), this.$input.data("edit") && this.unedit(b), !1)
            }
        },
        next: function(a) {
            if (a) {
                var b = this.$wrapper.find(".active:first"),
                c = b && this.firstActiveToken ? b.index() < this.firstActiveToken.index() : !1;
                if (c) return this.deactivate(b)
            }
            var d = this.$wrapper.find(".active:last"),
            e = d.nextAll(".token:first");
            return e.length ? void this.activate(e, a) : void this.$input.focus()
        },
        prev: function(a) {
            if (a) {
                var b = this.$wrapper.find(".active:last"),
                c = b && this.firstActiveToken ? b.index() > this.firstActiveToken.index() : !1;
                if (c) return this.deactivate(b)
            }
            var d = this.$wrapper.find(".active:first"),
            e = d.prevAll(".token:first");
            return e.length || (e = this.$wrapper.find(".token:first")),
            e.length || a ? void this.activate(e, a) : void this.$input.focus()
        },
        activate: function(b, c, d, e) {
            if (b) {
                if ("undefined" == typeof e) var e = !0;
                if (d) var c = !0;
                if (this.$copyHelper.focus(), c || (this.$wrapper.find(".active").removeClass("active"), e ? this.firstActiveToken = b: delete this.firstActiveToken), d && this.firstActiveToken) {
                    var f = this.firstActiveToken.index() - 2,
                    g = b.index() - 2,
                    h = this;
                    this.$wrapper.find(".token").slice(Math.min(f, g) + 1, Math.max(f, g)).each(function() {
                        h.activate(a(this), !0)
                    })
                }
                b.addClass("active"),
                this.$copyHelper.val(this.getTokensList(null, null, !0)).select()
            }
        },
        activateAll: function() {
            var b = this;
            this.$wrapper.find(".token").each(function(c) {
                b.activate(a(this), 0 !== c, !1, !1)
            })
        },
        deactivate: function(a) {
            a && (a.removeClass("active"), this.$copyHelper.val(this.getTokensList(null, null, !0)).select())
        },
        toggle: function(a) {
            a && (a.toggleClass("active"), this.$copyHelper.val(this.getTokensList(null, null, !0)).select())
        },
        edit: function(b) {
            if (b) {
                var c = b.data("value"),
                d = b.find(".token-label").text(),
                e = a.Event("tokenfield:edittoken");
                if (e.token = {
                    value: c,
                    label: d
                },
                e.relatedTarget = b.get(0), this.$element.trigger(e), e.token) {
                    c = e.token.value,
                    d = e.token.label,
                    b.find(".token-label").text(c);
                    var f = b.outerWidth(),
                    g = this.$input.hasClass("tt-input") ? this.$input.parent() : this.$input;
                    b.replaceWith(g),
                    this.preventCreateTokens = !0,
                    this.$input.val(c).select().data("edit", !0).width(f),
                    this.update()
                }
            }
        },
        unedit: function(a) {
            var b = this.$input.hasClass("tt-input") ? this.$input.parent() : this.$input;
            if (b.appendTo(this.$wrapper), this.$input.data("edit", !1), this.$mirror.text(""), this.update(), a) {
                var c = this;
                setTimeout(function() {
                    c.$input.focus()
                },
                1)
            }
        },
        remove: function(b, c) {
            if (!this.$input.is(document.activeElement) && !this.disabled) {
                var d = "click" === b.type ? a(b.target).closest(".token") : this.$wrapper.find(".token.active");
                if ("click" !== b.type) {
                    if (!c) var c = "prev";
                    if (this[c](), "prev" === c) var e = 0 === d.first().prevAll(".token:first").length
                }
                var f = a.Event("tokenfield:removetoken");
                f.token = this.getTokenData(d);
                var g = a.Event("change");
                g.initiator = "tokenfield",
                d.remove(),
                this.$element.val(this.getTokensList()).trigger(f).trigger(g),
                (!this.$wrapper.find(".token").length || "click" === b.type || e) && this.$input.focus(),
                this.$input.css("width", this.options.minWidth + "px"),
                this.update(),
                b.preventDefault(),
                b.stopPropagation()
            }
        },
        update: function() {
            var a = this.$input.val(),
            b = parseInt(this.$input.css("padding-left"), 10),
            c = parseInt(this.$input.css("padding-right"), 10),
            d = b + c;
            if (this.$input.data("edit")) {
                if (a || (a = this.$input.prop("placeholder")), a === this.$mirror.text()) return;
                this.$mirror.text(a);
                var e = this.$mirror.width() + 10;
                if (e > this.$wrapper.width()) return this.$input.width(this.$wrapper.width());
                this.$input.width(e)
            } else {
                if (this.$input.css("width", this.options.minWidth + "px"), "rtl" === this.textDirection) return this.$input.width(this.$input.offset().left + this.$input.outerWidth() - this.$wrapper.offset().left - parseInt(this.$wrapper.css("padding-left"), 10) - d - 1);
                this.$input.width(this.$wrapper.offset().left + this.$wrapper.width() + parseInt(this.$wrapper.css("padding-left"), 10) - this.$input.offset().left - d - 2)
            }
        },
        focusInput: function(b) {
            if (!a(b.target).closest(".token").length && !a(b.target).closest(".token-input").length) {
                var c = this;
                setTimeout(function() {
                    c.$input.focus()
                },
                0)
            }
        },
        search: function() {
            this.$input.data("ui-autocomplete") && this.$input.autocomplete("search")
        },
        disable: function() {
            this.disabled = !0,
            this.$input.prop("disabled", !0),
            this.$element.prop("disabled", !0),
            this.$wrapper.addClass("disabled")
        },
        enable: function() {
            this.disabled = !1,
            this.$input.prop("disabled", !1),
            this.$element.prop("disabled", !1),
            this.$wrapper.removeClass("disabled")
        },
        destroy: function() {
            
        }
    };
    var d = a.fn.tokenfield;
    return a.fn.tokenfield = function(b, d) {
        var e, f = [];
        Array.prototype.push.apply(f, arguments);
        var g = this.each(function() {
            var g = a(this),
            h = g.data("bs.tokenfield"),
            i = "object" == typeof b && b;
            "string" == typeof b && h && h[b] ? (f.shift(), e = h[b].apply(h, f)) : h || "string" == typeof b || d || g.data("bs.tokenfield", h = new c(this, i))
        });
        return "undefined" != typeof e ? e: g
    },
    a.fn.tokenfield.defaults = {
        
    },
    a.fn.tokenfield.Constructor = c,
    a.fn.tokenfield.noConflict = function() {
        return a.fn.tokenfield = d,
        this
    },
    c
}),

define("views/quicktools/waybill", ["backbone", "tokenfield", "helper", "models/waybill"],
function(a, b, c, d) {
    return a.View.extend({
        events: {
            "click .primary-button": "queryBillNumbers",
            "mouseout .tokenfield.form-control": "stopPropagation",
            "focusin input.token-input": "setInputToken",
            "focusout input.token-input": "setInputToken"
        },
        initialize: function() {
            this.$el.addClass("inithack");
            var a = this.$(".bill-numbers-input").attr("placeholder");
            this.setupTokenField(this.$(".bill-numbers-input"), a),
            this.$el.removeClass("inithack")
        },
        setInputToken: function(a) {
            var b = this;
            "focusin" === a.type ? (this.$(a.target).data("input-status", !0), this.$el.find(".bill-number").removeClass("folded")) : (this.$(a.target).data("input-status", !1), this.$el.find(".token").length || this.$el.find(".token-input").val() || setTimeout(function() {
                b.$el.find(".tokenfield.form-control").hasClass("focus") || b.$el.find(".bill-number").addClass("folded")
            },
            200))
        },
        stopPropagation: function(a) {
            a.stopPropagation()
        },
        placeHolderToggle: function() {
            if (0 === this.inputedBillNumbers().length) {
                var a = this.$(".tokenfield.form-control"),
                b = this.$(".token-input"),
                c = a.offset().left + a.width() + parseInt(a.css("padding-left"), 10) - b.offset().left - 1;
                b.attr("placeholder", this.placeholder).width(c).placeholder()
            } else this.$(".token-input").attr("placeholder", "").removeClass("placeholder")
        },
        setupTokenField: function(a, b) {
            this.placeholder = b;
            var c = this;
            this.$tokenfield = a;
            var e = 20,
            f = function() {
                window.setTimeout(function() {
                    c.validateBillNumbersInput()
                },
                0)
            };
            c.$tokenfield.attr("placeholder", b).on("tokenfield:removetoken",
            function() {
                c.$(".error[data-error=limit-exceeded]").hide(),
                c.placeHolderToggle(),
                c.inputValidate() && c.$(".error[data-error=bill-number-format]").hide(),
                c.validateBillNumbersInput()
            }).on("tokenfield:createtoken",
            function(a) {
                d.validateBillNumber(a.token.value) || $(a.relatedTarget).addClass("invalid"),
                c.placeHolderToggle(),
                f()
            }).on("tokenfield:preventduplicate",
            function() {
                window.setTimeout(function() {
                    c.$(".error[data-error=bill-number-format]").show()
                },
                200)
            }).on("tokenfield:edittoken",
            function() {
                c.$(".token-input").on("blur",
                function() {
                    f()
                }).on("keyup",
                function(a) {
                    a.currentTarget.value.length || (c.placeHolderToggle(), f())
                })
            }).tokenfield({
                createTokensOnBlur: !0,
                delimiter: [",", "\n", "	", " ", "，"],
                limit: e,
                minWidth: 90,
                leakCallback: function() {
                    c.$(".token-input").val(""),
                    c.$(".error[data-error=limit-exceeded]").show()
                }
            }),
            c.$(".token-input").attr("placeholder", b).placeholder()
        },
        inputedBillNumbers: function() {
            var a;
            try {
                a = this.$tokenfield.tokenfield("getTokensList").split(",")
            } catch(b) {
                a = this.$tokenfield.tokenfield("getTokensList").val().split(",")
            }
            return a = _.map(a,
            function(a) {
                return a.trim()
            }),
            _.compact(a)
        },
        hasInputs: function() {
            var a = !1;
            return _.each(this.inputedBillNumbers(),
            function(b) {
                b.length && (a = !0)
            }),
            a
        },
        inputValidate: function() {
            return d.validateBillNumbers(this.inputedBillNumbers())
        },
        validateBillNumbersInput: function() {
            this.inputValidate() ? this.$(".error[data-error=bill-number-format]").hide() : this.$(".error[data-error=bill-number-format]").show(),
            this.updateQueryButtonStatus()
        },
        updateQueryButtonStatus: function() {
            var a = d.validateBillNumbers(this.inputedBillNumbers());
            this.$("button").toggleClass("disabled", !a)
        },
        queryBillNumbers: function() {
            this.inputValidate() && this.hasInputs() && (window.location.href = c.getDynamicURLWithContext("/waybill/#search/bill-number/" + this.inputedBillNumbers().join(",")))
        }
    })
}),
define("views/waybill/billNumber/subView", ["tokenfield", "backbone", "models/waybill", "views/quicktools/waybill", "helper"],
function(a, b, c, d, e) {
    return d.extend({
        el: ".bill-number-wrapper",
        events: {
            "click .primary-button": "queryBillNumbers",
            "click .clear-inputs": "clearInputs",
            "click .verification-code .refresh": "refreshValidationCode",
            "click .verification-code img": "refreshValidationCode",
            "keyup .verification-code input": "updateQueryButtonStatus"
        },
        initialize: function() {
            var a = this.$(".tokenfield").attr("placeholder");
            this.setupTokenField(this.$(".tokenfield"), a)
        },
        updateBillNumbers: function(a) {
            var b = a.indexOf("?");
            b > -1 && (a = a.substring(0, b)),
            this.$(".token-input").attr("placeholder", "").removeClass("placeholder"),
            this.$tokenfield.tokenfield("setTokens", a.commaReplace().split(",")),
            this.$(".token-input").val("");
            var c = this;
            window.setTimeout(function() {
                c.queryBillNumbers()
            },
            100)
        },
        validateValidationCode: function() {
            if (this.$(".verification-code").is(":visible")) {
                var a = this.$(".verification-code input").val().length > 0;
                return a && this.inputedBillNumbers().length
            }
            return ! 0
        },
        updateQueryButtonStatus: function() {
            var a = c.validateBillNumbers(this.inputedBillNumbers()) && this.validateValidationCode(),
            b = this.$("button");
            a && b.text(b.data("resetText")),
            b.toggleClass("disabled", !a)
        },
        showValidationCode: function() {
            this.$(".verification-code").show(),
            this.refreshValidationCode()
        },
        showValidationCodeAtFocus: function() {
            var a = this;
            this.$tokenfield.siblings(".token-input").one("focus",
            function() {
                a.showValidationCode()
            })
        },
        showValidationCodeError: function() {
            this.$(".validation-code-error").show()
        },
        queryBillNumbers: function() {
            if (!this.inputValidate() || !this.hasInputs()) return this.collection.trigger("resetItemsWithEmptyInput"),
            void this.$(".error[data-error=bill-number-format]").show();
            this.$(".error").hide(),
            this.$(".token-input").val("");
            var a = this.$tokenfield.tokenfield("getTokensList", ",").split(", ");
            a = _.map(a,
            function(a) {
                return a.trim()
            });
            var b = this.$(".verification-code input"),
            c = null;
            b.val() !== b.attr("placeholder") && (c = b.val());
            var d = this,
            e = this.$(".primary-button");
            window.setTimeout(function() {
                e.button("loading")
            },
            100),
            this.collection.trigger("fetchItemsWithBillNumbers", {
                billNumbers: a,
                validationCode: c,
                showValidationCode: function() {
                    d.showValidationCode()
                },
                showValidationCodeError: function() {
                    d.showValidationCodeError()
                },
                showValidationCodeAtFocus: function() {
                    d.showValidationCodeAtFocus()
                },
                showNetworkError: function() {
                    d.$(".error[data-error=server-network]").show()
                },
                searchComplete: function() {
                    e.button("reset"),
                    window.setTimeout(function() {
                        d.updateQueryButtonStatus()
                    },
                    0)
                }
            })
        },
        clearInputs: function() {
            this.$(".token-input").val(""),
            this.$tokenfield.tokenfield("setTokens", []),
            this.$tokenfield.trigger("tokenfield:removetoken"),
            this.validateBillNumbersInput(),
            this.queryBillNumbers(),
            this.$(".error").hide(),
            this.placeHolderToggle()
        },
        refreshValidationCode: function() {
            var a = this.$("#validation-image"),
            b = $("#validation-image-child"),
            c = e.getRESTfulDomain("captcha/bill?force=true&time=" + (new Date).getTime());
            a && a.attr("src", c),
            b && b.attr("src", c),
            this.$(".verification-code input").val(""),
            this.updateQueryButtonStatus(),
            this.$(".validation-code-error").hide()
        }
    })
}),




define("views/waybill/masterController", [ "views/waybill/billNumber/subView",   "collections/waybills"],
function(a, b, c, d, e) {
    return Backbone.View.extend({
        initialize: function() {
            this.waybills = new e,
            this.billNumberSubView = null,
            this.phoneNumberSubView = null
        }
    })
}),
define("routers/shippingDetailRouter", ["backbone"],
function(a, b) {
    
}),
define("views/quicktools/quicktools", ["views/quicktools/waybill"],
function(a) {
    return Backbone.View.extend({
        events: {
            "click .primary-button": "queryBillNumbers",
            "click .quick-tool-title.popup": "preventDefault",
            "mouseout .quick-tool-container": "closeQuickTool",
            "mouseenter .quick-tool-container": "showQuickTool"
        },
        preventDefault: function(a) {
            a.preventDefault()
        },
        initialize: function() {
            new a({
                el: this.$(".waybill .quick-tool")
            })
        },
        closeQuickTool: function(a) {
            var b = this,
            c = $(a.currentTarget).find(".quick-tool");
            $.contains(this.$(".quick-tool-container")[0], a.relatedTarget) || (b.hoverOutTimeOut = window.setTimeout(function() {
                c.removeClass("show"),
                b.$(".quick-tool-title").removeClass("hover"),
                b.$(".quick-tool").first().removeClass("hide")
            },
            100))
        },
        showQuickTool: function(a) {
            this.hoverOutTimeOut && window.clearTimeout(this.hoverOutTimeOut);
            var b = $(a.currentTarget).find(".quick-tool");
            this.currentQuickTool = b,
            this.$(".quick-tool").first().addClass("hide"),
            this.$(".quick-tool-title").addClass("hover"),
            b.addClass("show")
        }
    })
}),


define("views/manager", ["backbone", "views/services/servicesContainer", "views/services/locationInput", "views/otherService", "routers/shippingDetailRouter", "views/quicktools/quicktools"],
function(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, _) {
    return a.View.extend({
        initialize: function() {
            var ab = $("body");
            $(".index-page").length > 0 && (new f({
                el: ".quick-tools"
            }))
        }
    })
}),

require(["views/manager"],
function(a) {
    new a
}),
define("main",
function() {});